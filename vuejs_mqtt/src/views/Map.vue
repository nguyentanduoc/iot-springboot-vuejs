<template>
	<div id="map">
		<button @click="rotateMap">rotateMap</button>
		<img id="arrowCar" src="../assets/img/location-arrow-flat.png" alt="arrowCar">
		<MglMap
				:accessToken="accessToken"
				:mapStyle="style"
				:center="[106.633894,10.857794]"
				:zoom="17"
				:dragRotate="true"
				@load="onMapLoaded">
			<MglMarker :coordinates="[106.633894,10.857794]">
				<MglPopup :showed="false">
					<div>Hello, I'm popup!</div>
				</MglPopup>
			</MglMarker>
			<MglMarker :coordinates="[106.632717,10.858752]" :draggable="true">
			</MglMarker>
			<MglGeolocateControl position="top-right"/>
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
    MglPopup,
    MglGeolocateControl,
    MglGeojsonLayer,
    MglNavigationControl,
    MglScaleControl
  } from "vue-mapbox";
  export default {
    components: {
      MglMap,
      MglMarker,
      MglPopup,
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
                      106.633894,
                      10.857794
                    ],
                    [
                      106.63384,
                      10.857884
                    ],
                    [
                      106.633751,
                      10.857992
                    ],
                    [
                      106.633682,
                      10.858097
                    ],
                    [
                      106.633562,
                      10.858294
                    ],
                    [
                      106.633426,
                      10.858381
                    ],
                    [
                      106.633185,
                      10.858507
                    ],
                    [
                      106.633021,
                      10.858598
                    ],
                    [
                      106.632825,
                      10.858689
                    ],
                    [
                      106.632717,
                      10.858752
                    ],
                    [
                      106.632574,
                      10.858857
                    ],
                    [
                      106.632275,
                      10.859067
                    ],
                    [
                      106.631968,
                      10.859246
                    ],
                    [
                      106.631765,
                      10.859388
                    ],
                    [
                      106.631462,
                      10.859562
                    ],
                    [
                      106.63121,
                      10.859727
                    ],
                    [
                      106.630981,
                      10.859854
                    ],
                    [
                      106.630822,
                      10.859947
                    ],
                    [
                      106.630873,
                      10.860002
                    ],
                    [
                      106.630945,
                      10.860082
                    ],
                    [
                      106.631108,
                      10.860272
                    ],
                    [
                      106.631231,
                      10.860415
                    ],
                    [
                      106.631824,
                      10.86106
                    ],
                    [
                      106.631941,
                      10.861117
                    ],
                    [
                      106.632398,
                      10.861384
                    ],
                    [
                      106.63302,
                      10.861681
                    ],
                    [
                      106.633097,
                      10.86124
                    ],
                    [
                      106.633129,
                      10.861179
                    ],
                    [
                      106.633192,
                      10.861132
                    ],
                    [
                      106.633692,
                      10.860904
                    ],
                    [
                      106.634218,
                      10.86066
                    ],
                    [
                      106.634597,
                      10.860492
                    ],
                    [
                      106.634709,
                      10.860441
                    ],
                    [
                      106.634921,
                      10.860344
                    ],
                    [
                      106.634969,
                      10.860344
                    ],
                    [
                      106.635088,
                      10.86032
                    ],
                    [
                      106.635387,
                      10.8602
                    ],
                    [
                      106.635706,
                      10.860044
                    ],
                    [
                      106.635789,
                      10.860003
                    ],
                    [
                      106.636303,
                      10.859751
                    ],
                    [
                      106.636345,
                      10.859766
                    ],
                    [
                      106.636452,
                      10.859858
                    ],
                    [
                      106.636528,
                      10.859883
                    ],
                    [
                      106.636688,
                      10.859823
                    ],
                    [
                      106.636967,
                      10.859719
                    ],
                    [
                      106.637285,
                      10.859571
                    ],
                    [
                      106.63723,
                      10.859367
                    ],
                    [
                      106.637201,
                      10.859312
                    ],
                    [
                      106.636825,
                      10.858566
                    ],
                    [
                      106.636797,
                      10.858503
                    ],
                    [
                      106.636855,
                      10.858445
                    ],
                    [
                      106.637029,
                      10.858374
                    ],
                    [
                      106.637321,
                      10.858277
                    ],
                    [
                      106.637525,
                      10.858198
                    ],
                    [
                      106.637737,
                      10.8581
                    ],
                    [
                      106.637911,
                      10.857953
                    ],
                    [
                      106.638174,
                      10.857826
                    ],
                    [
                      106.638345,
                      10.857769
                    ],
                    [
                      106.638459,
                      10.857718
                    ],
                    [
                      106.638509,
                      10.857686
                    ],
                    [
                      106.638649,
                      10.857597
                    ],
                    [
                      106.638802,
                      10.857302
                    ],
                    [
                      106.638988,
                      10.857068
                    ],
                    [
                      106.639153,
                      10.856849
                    ],
                    [
                      106.639258,
                      10.856772
                    ],
                    [
                      106.639286,
                      10.856672
                    ],
                    [
                      106.639325,
                      10.8566
                    ],
                    [
                      106.639391,
                      10.856511
                    ],
                    [
                      106.639416,
                      10.856469
                    ],
                    [
                      106.639445,
                      10.856425
                    ],
                    [
                      106.639435,
                      10.856379
                    ],
                    [
                      106.63929,
                      10.85604
                    ],
                    [
                      106.639203,
                      10.855842
                    ],
                    [
                      106.639033,
                      10.855459
                    ],
                    [
                      106.638869,
                      10.855086
                    ],
                    [
                      106.638856,
                      10.855058
                    ],
                    [
                      106.638676,
                      10.85467
                    ],
                    [
                      106.638523,
                      10.854335
                    ],
                    [
                      106.638773,
                      10.854154
                    ],
                    [
                      106.6391,
                      10.853951
                    ],
                    [
                      106.639167,
                      10.853911
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
    },
    methods: {
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
              animate: true
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
		/*transform: rotate(180deg);*/
	}
</style>