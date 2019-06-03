<template>
	<div id="map">
		<MglMap :accessToken="accessToken" :mapStyle="style">
			<MglMarker :coordinates="coordinates">
				<MglPopup :showed="false">
					<div>Hello, I'm popup!</div>
				</MglPopup>
			</MglMarker>
			<MglGeolocateControl position="top-right"/>
		</MglMap>
		<MglGeojsonLayer
				sourceId="myLayer"
				layerId="myLayer"
				:layer="geoJsonlayer"
				:source="geoJsonSource"
		/>
	</div>
</template>

<script>
  import Mapbox from "mapbox-gl";
  import {MglMap, MglMarker, MglPopup, MglGeolocateControl, MglGeojsonLayer} from "vue-mapbox";
  import data from '../assets/data/simple.json'

  export default {
    components: {
      MglMap,
      MglMarker,
      MglPopup,
      MglGeolocateControl,
      MglGeojsonLayer
    },
    data() {
      return {
        accessToken: 'pk.eyJ1IjoibnRkdW9jIiwiYSI6ImNqdWNpZGEyZTBtZ2E0ZXFxemw4ZXhvNGYifQ.LwX-4Db561hcAVS4WTiNzA',
        style: 'mapbox://styles/mapbox/streets-v10',
        coordinates: [ -76.53063297271729,  39.18174077994108],
        popupCoordinates: [10, 10],
        showed: true,
        geoJsonSource: {
          "mapbox-streets": {
            "type": "vector",
            "tiles": [
              "http://a.example.com/tiles/{z}/{x}/{y}.pbf",
              "http://b.example.com/tiles/{z}/{x}/{y}.pbf"
            ],
            "maxzoom": 14
          }
        },
        geoJsonlayer: {
          "layers": [
            {
              "id": "water",
              "source": "mapbox-streets",
              "source-layer": "water",
              "type": "fill",
              "paint": {
                "fill-color": "#00ffff"
              }
            }
          ]
        }
      };
    },

    created() {
      this.mapbox = Mapbox;
    }
  };
</script>