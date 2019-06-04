<template>
	<div id="map">
		<MglMap :accessToken="accessToken" :mapStyle="style">
			<MglMarker :coordinates="coordinates">
				<MglPopup :showed="false">
					<div>Hello, I'm popup!</div>
				</MglPopup>
			</MglMarker>
			<MglGeojsonLayer
					:sourceId="geoJsonSource.id"
					:source="geoJsonSource"
					layerId="some_layer"
					minzoom="3"
			/>
			<MglGeolocateControl position="top-right"/>
		</MglMap>
	</div>
</template>

<script>
  import Mapbox from "mapbox-gl";
  import {MglMap, MglMarker, MglPopup, MglGeolocateControl, MglGeojsonLayer} from "vue-mapbox";

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
        coordinates: [-76.53063297271729, 39.18174077994108],
        popupCoordinates: [10, 10],
        showed: true,
        geoJsonSource: {
          "id": "route",
          "type": "line",
          "source": {
            "type": "geojson",
            "data": {
              "type": "Feature",
              "properties": {},
              "geometry": {
                "type": "LineString",
                "coordinates": [
                  [-122.48369693756104, 37.83381888486939],
                  [-122.48348236083984, 37.83317489144141],
                  [-122.48339653015138, 37.83270036637107],
                  [-122.48356819152832, 37.832056363179625],
                  [-122.48404026031496, 37.83114119107971],
                  [-122.48404026031496, 37.83049717427869],
                  [-122.48348236083984, 37.829920943955045],
                  [-122.48356819152832, 37.82954808664175],
                  [-122.48507022857666, 37.82944639795659],
                  [-122.48610019683838, 37.82880236636284],
                  [-122.48695850372314, 37.82931081282506],
                  [-122.48700141906738, 37.83080223556934],
                  [-122.48751640319824, 37.83168351665737],
                  [-122.48803138732912, 37.832158048267786],
                  [-122.48888969421387, 37.83297152392784],
                  [-122.48987674713133, 37.83263257682617],
                  [-122.49043464660643, 37.832937629287755],
                  [-122.49125003814696, 37.832429207817725],
                  [-122.49163627624512, 37.832564787218985],
                  [-122.49223709106445, 37.83337825839438],
                  [-122.49378204345702, 37.83368330777276]
                ]
              }
            }
          },
          "layout": {
            "line-join": "round",
            "line-cap": "round"
          },
          "paint": {
            "line-color": "#888",
            "line-width": 8
          }
        },
        geoJsonlayer: {
          "id": "route",
          "source": "mapbox-streets",
          "source-layer": "route",
          "type": "line",
          "paint": {
            "fill-color": "#00ffff"
          }
        }
      };
    },

    created() {
      this.mapbox = Mapbox;
    }
  };
</script>