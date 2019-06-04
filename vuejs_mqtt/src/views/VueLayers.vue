<template>
	<div id="vue-layers-ntd">
		<div>
			<button @click="addLine">addLine</button>
			<button @click="moveMap">moveMap</button>
		</div>
		<vl-map
				:load-tiles-while-animating="true"
				:load-tiles-while-interacting="true"
				data-projection="EPSG:4326"
				style="height: 100%"
				@zoom="zoomAction"
				:move-tolerance="moveTolerance">
			<vl-layer-tile>
				<vl-source-osm></vl-source-osm>
			</vl-layer-tile>
			<vl-view :zoom.sync="zoom" :center.sync="center" :rotation.sync="rotation"></vl-view>
			<vl-geoloc @update:position="geolocPosition = $event">
				<template slot-scope="geoloc">
					<vl-feature v-if="geoloc.position" id="position-feature">
						<vl-geom-point :coordinates="geoloc.position"></vl-geom-point>
						<vl-style-box>
							<vl-style-icon :src="marker" :scale="0.4" :anchor="[0.5, 1]"></vl-style-icon>
						</vl-style-box>
					</vl-feature>
				</template>
			</vl-geoloc>
			<vl-layer-vector>
				<vl-source-vector :features.sync="features"></vl-source-vector>
				<vl-style-box>
					<vl-style-stroke color="green" :width="4"></vl-style-stroke>
					<vl-style-fill color="rgba(255,255,255,0.5)"></vl-style-fill>
				</vl-style-box>
			</vl-layer-vector>
			<vl-feature v-if="center1.length = 2" id="position-feature-2">
				<vl-geom-point :coordinates="center1"></vl-geom-point>
				<vl-style-box>
					<vl-style-icon :src="marker" :scale="0.4" :anchor="[0.1, 0.1]"></vl-style-icon>
				</vl-style-box>
			</vl-feature>
			<vl-feature v-if="carCoordinate.length > 1" id="position-feature-car">
				<vl-geom-point :coordinates="carCoordinate"></vl-geom-point>
				<vl-style-box>
					<vl-style-icon :src="car" :scale="0.4" :anchor="[0.1, 0.95]"></vl-style-icon>
				</vl-style-box>
			</vl-feature>
			<vl-feature id="marker-2" ref="marker" :properties="{ start: Date.now(), duration: 2500 }">
				<template slot-scope="feature">
					<vl-geom-point :coordinates="[106.633894, 10.857794]"></vl-geom-point>
					<vl-style-box>
						<vl-style-icon
								:src="flag"
								:scale="0.5"
								:anchor="[0.1, 0.95]"
								:size="[128, 128]"
						></vl-style-icon>
					</vl-style-box>
					<!-- overlay binded to feature -->
				</template>
			</vl-feature>
		</vl-map>
		<!--<div style="padding: 20px">-->
		<!--Zoom: {{ zoom }}<br>-->
		<!--Center: {{ center }}<br>-->
		<!--Rotation: {{ rotation }}<br>-->
		<!--My geolocation: {{ geolocPosition }}-->
		<!--</div>-->
	</div>
</template>

<script>
  import marker from '../assets/img/marker.png';
  import flag from '../assets/img/flag.png';
  import car from '../assets/img/car_50.png';

  export default {
    name: "VueLayers",
    data() {
      return {
        zoom: 15,
        center: [106.633894, 10.857794],
        center1: [106.63384, 10.857884],
        rotation: 0,
        geolocPosition: [106.64093129999999, 10.8469123],
        marker: marker,
        flag: flag,
        features: [],
        i: 0,
        moveTolerance: 20,
        carCoordinate: [],
        car: car
      }
    },
    beforeCreate() {
      this.$mqtt.subscribe('cordinate')
    },
    mqtt: {
      'cordinate': function (val) {
        const string = new TextDecoder("utf-8").decode(val);
        let object = JSON.parse(string);
        this.carCoordinate = object.coordinates;
      }
    },
    methods: {
      zoomAction: function (zoom) {
        this.zoom = zoom;
      },
      addLine: function () {
        this.features = [
          {
            type: "Feature",
            id: "cjwheochw00oh5mnlrkuw3lc1",
            geometry: {
              type: "LineString",
              coordinates: [
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
                ],
              ],
            },
          },
        ]
      },
      moveMap: function () {
        this.center1 = this.features[0].geometry.coordinates[this.i];
        this.center = this.features[0].geometry.coordinates[this.i];
        this.i += 1;
      }
    }
  }
</script>

<style scoped>

</style>