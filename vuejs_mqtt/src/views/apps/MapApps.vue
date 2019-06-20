<template :id="$options.name">
	<div id="map">
		<!--<button @click="rotateMap">rotateMap</button>-->
		<!--<img id="arrowCar" src="../assets/img/location-arrow-flat.png" alt="arrowCar">-->
		<MglMap
				:accessToken="accessToken"
				:mapStyle="style"
				:center="center"
				:zoom="17"
				:dragRotate="true"
				@load="onMapLoaded">
			<MglMarker :coordinates="marker" anchor="center"></MglMarker>
			<MglGeolocateControl position="top-left"/>
			<MglNavigationControl position="top-right"/>
			<MglScaleControl position="bottom-left"/>
			<MglGeojsonLayer
					:sourceId="geoJsonSource.id"
					:source="geoJsonSource"
					layerId="myLayer"
					:layer="geoJsonlayer"
			/>
		</MglMap>
	</div>
</template>

<script>
  import {
    MglMap,
    MglMarker,
    MglGeolocateControl,
    MglGeojsonLayer,
    MglNavigationControl,
    MglScaleControl
  } from "vue-mapbox";

  export default {
    name: "Map",
    components: {
      MglMap,
      MglMarker,
      MglGeolocateControl,
      MglGeojsonLayer,
      MglNavigationControl,
      MglScaleControl
    },
    data() {
      return {
        accessToken: 'pk.eyJ1IjoibnRkdW9jIiwiYSI6ImNqdWNpZGEyZTBtZ2E0ZXFxemw4ZXhvNGYifQ.LwX-4Db561hcAVS4WTiNzA',
        style: 'mapbox://styles/mapbox/streets-v10',
        coordinates: [-76.53063297271729, 39.18174077994108],
        center: [106.633894, 10.857794],
        marker: [106.633894, 10.857794],
        popupCoordinates: [10, 10],
        showed: true,
        geoJsonSource: {
          "id": "water",
          "type": "vector",
          "maxzoom": 14
        },
        geoJsonlayer: {
          'id': 'cluster-count',
          'type': 'line',
          'source': {
            'type': 'geojson',
            'data': {
              'type': 'FeatureCollection',
              'features': [{
                'type': 'Feature',
                'properties': {
                  'color': '#F7455D' // red
                },
                'geometry': {
                  'type': 'LineString',
                  'coordinates': [
                    [
                      106.654879,
                      10.862069
                    ],
                    [
                      106.65488,
                      10.862056
                    ],
                    [
                      106.654888,
                      10.861973
                    ],
                    [
                      106.654895,
                      10.861835
                    ],
                    [
                      106.654948,
                      10.86183
                    ],
                    [
                      106.655005,
                      10.861829
                    ],
                    [
                      106.655,
                      10.861963
                    ],
                    [
                      106.654978,
                      10.862105
                    ],
                    [
                      106.654969,
                      10.862164
                    ],
                    [
                      106.654957,
                      10.862227
                    ],
                    [
                      106.654945,
                      10.86229
                    ],
                    [
                      106.654913,
                      10.862499
                    ],
                    [
                      106.654876,
                      10.86273
                    ],
                    [
                      106.654866,
                      10.862783
                    ],
                    [
                      106.654794,
                      10.863184
                    ],
                    [
                      106.654742,
                      10.863479
                    ],
                    [
                      106.65469,
                      10.863774
                    ],
                    [
                      106.655251,
                      10.863761
                    ],
                    [
                      106.655738,
                      10.863761
                    ],
                    [
                      106.656015,
                      10.86376
                    ],
                    [
                      106.656011,
                      10.863196
                    ],
                    [
                      106.65601,
                      10.863126
                    ],
                    [
                      106.656016,
                      10.863079
                    ],
                    [
                      106.656024,
                      10.863045
                    ],
                    [
                      106.656043,
                      10.863013
                    ],
                    [
                      106.656057,
                      10.863004
                    ],
                    [
                      106.656075,
                      10.862999
                    ],
                    [
                      106.656111,
                      10.862989
                    ],
                    [
                      106.6567,
                      10.862977
                    ],
                    [
                      106.656934,
                      10.862975
                    ],
                    [
                      106.657424,
                      10.862971
                    ],
                    [
                      106.657946,
                      10.862978
                    ],
                    [
                      106.658311,
                      10.862973
                    ],
                    [
                      106.658311,
                      10.862838
                    ],
                    [
                      106.658299,
                      10.862719
                    ],
                    [
                      106.658274,
                      10.862579
                    ],
                    [
                      106.658241,
                      10.862424
                    ],
                    [
                      106.658201,
                      10.862265
                    ],
                    [
                      106.658193,
                      10.862232
                    ],
                    [
                      106.658143,
                      10.862009
                    ],
                    [
                      106.658125,
                      10.861921
                    ],
                    [
                      106.658114,
                      10.861858
                    ],
                    [
                      106.657167,
                      10.861906
                    ],
                    [
                      106.657037,
                      10.861913
                    ],
                    [
                      106.657027,
                      10.861847
                    ],
                    [
                      106.656824,
                      10.861857
                    ],
                    [
                      106.6568,
                      10.861858
                    ]
                  ]
                }
              }]
            }
          },
          'paint': {
            'line-color': '#ed6498',
            'line-width': 5,
            'line-translate': [1, 1]
          }
        },
        i: 0,
      };
    },
    mounted() {
      this.map = null;
      this.component = null;
      this.$mqtt.subscribe('arduino');
    },
    mqtt: {
      'arduino': function (data) {
        const asyncActions = this.component.actions;
        const jsonObject = this.bufferToJson(data);
        this.marker = jsonObject.data;
        this.center = jsonObject.data;
        asyncActions.easeTo({
          center: jsonObject.data,
          zoom: 17,
          // speed: 2000,
          // screenSpeed: 2000,
          duration: 3000,
          animate: true
        });
      },
    },
    methods: {
      bufferToJson: function (data) {
        const serializedDBuffer = JSON.stringify(data);
        const message = JSON.parse(serializedDBuffer);
        let str = "";
        for (let i = 0; i < message.data.length; i++) {
          str += String.fromCharCode(parseInt(message.data[i]));
        }
        return JSON.parse(str)
      },
      rotateMap: async function () {
        const asyncActions = this.component.actions;
        const {coordinates} = this.geoJsonlayer.source.data.features[0].geometry;
        let timerId;
        if (this.i <= coordinates.length - 1) {
          timerId = setInterval(() => {
            asyncActions.easeTo({
              center: coordinates[this.i],
              zoom: 17,
              // speed: 2000,
              // screenSpeed: 2000,
              duration: 3000,
              animate: false
            });
            this.i++;
          }, 2000);
        } else {
          clearInterval(timerId);
        }
        // await asyncActions.rotateTo(5, {duration: 500, animate: true})
      },
      onMapLoaded: async function (event) {
        this.map = event.map;
        this.component = event.component;
      }
    }
  };
</script>
<style>
	#arrowCar {
		z-index: 100;
		position: absolute;
		top: calc(50% + 30px);
		left: calc(50% - 30px);
		width: 40px;
	}
</style>