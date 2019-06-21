<template>
	<div :id='$options.name'>
		<form @submit.prevent="submit">
			<v-card>
				<v-toolbar :card="true" :flat="true">
					<v-toolbar-title><h4>Create Type Of Sensor</h4></v-toolbar-title>
				</v-toolbar>
				<v-divider></v-divider>
				<v-card-text>
					<v-alert
							:value="getAlert.isShow" :color="getAlert.color"
							v-if="getAlert.showOnComponent === $options.name">
						{{getAlert.message}}
					</v-alert>
					<v-text-field
							v-validate="'required|max:30'"
							v-model="name"
							label="Name"
							:error-messages="errors.collect('name')"
							data-vv-name="name"
					></v-text-field>
					<v-textarea
							v-validate="'required'"
							v-model="detail"
							label="Detail"
							:error-messages="errors.collect('detail')"
							data-vv-name="detail"
					></v-textarea>
				</v-card-text>
				<v-toolbar :flat="true">
					<v-btn color="success" type="submit">Submit</v-btn>
					<v-btn color="warning" @click="reset">Reset</v-btn>
				</v-toolbar>
			</v-card>
		</form>
	</div>
</template>

<script>
  import {mapActions, mapGetters} from 'vuex';

  export default {
    name: "FormCreateITypeOfSensor",
    $_veeValidate: {
      validator: 'new'
    },
    mounted() {
      this.$validator.localize('en', this.dictionary)
    },
    data() {
      return {
        name: '',
        detail: '',
        dictionary: {
          custom: {
            name: {
              required: () => 'Name can not be empty',
              max: 'The name field may not be greater than 30 characters'
            },
            detail: {
              required: () => 'detail can not be empty',
            }
          }
        }
      }
    },
    methods: {
      ...mapActions(['saveTypeOfSensor']),
      reset() {
        this.name = '';
        this.detail = '';
        this.$validator.reset();
      },
      submit() {
        this.$validator.validateAll().then((isValid) => {
          if (isValid) {
            this.saveTypeOfSensor({
              componentName: this.$options.name,
              data: {
                name: this.name,
                detail: this.detail
              }
            });
          }
        });
      }
    },
    computed: {
      ...mapGetters(['getAlert']),
    }
  }
</script>

<style scoped>

</style>