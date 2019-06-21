<template>
	<v-card :id='$options.name'>
		<v-toolbar card dense color="transparent">
			<v-toolbar-title><h4>Create sensor</h4></v-toolbar-title>
			<v-spacer></v-spacer>
		</v-toolbar>
		<v-divider></v-divider>
		<v-card-text>
			<form>
				<v-alert
						:value="getAlert.isShow" :color="getAlert.color"
						v-if="getAlert.showOnComponent === $options.name">
					{{getAlert.message}}
				</v-alert>
				<v-autocomplete
						chips deletable-chips
						v-model="account"
						label="Assign to User"
						:items="accountsSensorSelection"
						item-text="username"
						item-value="id"
						@input="changeAccount">
				</v-autocomplete>
				<v-layout>
					<v-flex xs10 md10>
						<v-autocomplete
								v-model="typeSensor"
								label="Type of sensor"
								item-text="name"
								item-value="id"
								:items="typeSensorSelection"
								single-line
								chips deletable-chips
						></v-autocomplete>
					</v-flex>
					<v-flex xs2 md2>
						<v-btn
								dark icon
								@click="dialogCreateTypeOfSensor = true"
								slot="activator"
								color="green">
							<v-icon>control_point</v-icon>
						</v-btn>
					</v-flex>
				</v-layout>
			</form>
		</v-card-text>
		<v-toolbar :flat="true">
			<v-btn color="success" @click="submit">submit</v-btn>
			<v-btn color="warning" @click="clear">clear</v-btn>
		</v-toolbar>
		<v-dialog
				max-width="600px"
				v-model="dialogCreateTypeOfSensor"
				@closeDialogCreateTypeOfSensor="dialogCreateTypeOfSensor = false">
			<dialog-create-type-of-sensor/>
		</v-dialog>
	</v-card>
</template>

<script>
  import {mapActions, mapGetters} from 'vuex';
  import DialogCreateTypeOfSensor from './DialogCreateTypeOfSensor';

  export default {
    name: "FormCreateSensor",
    components: {
      DialogCreateTypeOfSensor
    },
    data() {
      return {
        typeSensor: null,
        account: null,
        dialogCreateTypeOfSensor: false
      }
    },
    methods: {
      ...mapActions(['createSensor', 'getSensorOfUser']),
      submit() {
        this.createSensor({
          data: {
            typeSensor: this.typeSensor,
            account: this.account,
          },
          componentName: this.$options.name
        });
      },
      clear() {
        this.typeSensor = null;
        this.account = null;
      },
      changeAccount(account) {
        if (account) {
          this.getSensorOfUser({
            data: {
              userId: account,
            },
            componentName: this.$options.name
          })
        }
      }
    },
    beforeCreate() {
      this.$store.dispatch("initCreateSensor", {componentName: this.$options.name});
    },
    computed: {
      ...mapGetters(['accountsSensorSelection', 'typeSensorSelection', 'getAlert']),
    }
  }
</script>

<style scoped>

</style>