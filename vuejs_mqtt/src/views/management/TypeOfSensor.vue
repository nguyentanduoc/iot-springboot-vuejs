<template>
	<v-container :id="$options.name" grid-list-md text-xs-center>
		<v-layout row wrap>
			<v-flex xs3>
				<form-create-type-of-sensor/>
			</v-flex>
			<v-flex xs6>
				<list-type-of-sensor/>
			</v-flex>
		</v-layout>
	</v-container>
</template>

<script>
  import FormCreateTypeOfSensor from '../../components/typeOfsensorManagement/FormCreateITypeOfSensor'
  import ListTypeOfSensor from '../../components/typeOfsensorManagement/ListTypeOfSensor';

  export default {
    name: "TypeOfSensor",
    components: {
      FormCreateTypeOfSensor,
      ListTypeOfSensor
    }
  }
</script>

<style scoped>

</style>