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
								@click="createNewType"
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
	</v-card>
</template>

<script>
  import {mapActions, mapGetters} from 'vuex';

  export default {
    name: "FormCreateSensor",
    data() {
      return {
        typeSensor: null,
        account: null,
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
      createNewType() {
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