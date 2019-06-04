<template>
	<div>Lnao</div>
	<!--<l-map :zoom="zoom" :center="center">-->
		<!--<l-tile-layer :url="url"></l-tile-layer>-->
		<!--<l-marker :lat-lng="marker"></l-marker>-->
	<!--</l-map>-->
</template>

<script>
  // import {LMap, LTileLayer, LMarker} from 'vue2-leaflet'

  export default {
    name: "MapLeafLet",
    // components: { LMap, LTileLayer, LMarker }
    data() {
      return {
        // zoom:13,
        // center: L.latLng(47.413220, -1.219482),
        // url:'http://{s}.tile.osm.org/{z}/{x}/{y}.png',
        // attribution:'&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
        // marker: L.latLng(47.413220, -1.219482),
      };
    }
  }
</script>

<style scoped>

</style>