<template>
	<v-container :id="$options.name" grid-list-md text-xs-center>
		<v-layout row wrap>
			<v-flex xs3>
				<form-create-sensor></form-create-sensor>
			</v-flex>
			<v-flex xs9>
				<list-sensor-of-user></list-sensor-of-user>
			</v-flex>
		</v-layout>
	</v-container>
</template>

<script>
  import FormCreateSensor from '../../components/sensorManagament/FormCreateSensor';
  import ListSensorOfUser from '../../components/sensorManagament/ListSensorOfUser';

  export default {
    name: "Sensor",
    components: {
      FormCreateSensor,
      ListSensorOfUser
    }
  }
</script>

<style scoped>

</style>