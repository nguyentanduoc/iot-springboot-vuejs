<template>
	<div :id='$options.name'>
		<form @submit.prevent="submit">
			<v-card>
				<v-toolbar card dense corlor="transparent">
					<v-toolbar-title><h4>Create Type Of Sensor</h4></v-toolbar-title>
				</v-toolbar>
				<v-divider></v-divider>
				<v-card-text>
					<v-alert
							:value="getAlert.isShow" :color="getAlert.color"
							v-if="getAlert.showOnComponent === $options.name">
						{{getAlert.message}}
					</v-alert>
					<v-layout>
						<v-text-field
								v-model="name"
								label="Type of Sensor Name"
								data-vv-name="name"
								require
						></v-text-field>
					</v-layout>
					<v-layout>
						<v-textarea
								label="Detail Type of Sensor"
								v-model="detail"
								lable="Detail"
								data-vv-name="detail"
								require
						></v-textarea>
					</v-layout>
					<v-toolbar :flat="true">
						<v-btn corlor="success" type="submit">Submit</v-btn>
						<v-btn corlor="warning" @click="$emit('closeDialogCreateTypeOfSensor')">Close</v-btn>
					</v-toolbar>
				</v-card-text>
			</v-card>
		</form>
	</div>
</template>

<script>
  import {mapGetters} from 'vuex';

  export default {
    name: "DialogCreateTypeOfSensor",
    data() {
      return {
        name: '',
        detail: ''
      }
    },
    computed: {
      ...mapGetters(['getAlert'])
    },
    methods: {
      submit() {
        console.log("sub")
      }
    }
  }
</script>

<style scoped>

</style>