<template>
	<form>
		<v-card>
			<v-toolbar :flat="true">
				<v-toolbar-title>Create Account</v-toolbar-title>
			</v-toolbar>
			<v-card-text>
				<v-alert :value="getAlert.isShow" :color="getAlert.color">
					{{getAlert.message}}
				</v-alert>
				<v-text-field
						v-model="name"
						v-validate="'required|max:30'"
						:counter="30"
						:error-messages="errors.collect('name')"
						label="Name"
						data-vv-name="name"
						required
				></v-text-field>
				<v-text-field
						v-model="email"
						v-validate="'required|email'"
						:error-messages="errors.collect('email')"
						label="E-mail"
						data-vv-name="email"
						required
				></v-text-field>
				<v-autocomplete
						v-bind:items="roles"
						v-model="role"
						label="Role"
						item-text="name"
						item-value="id"
						:deletable-chips="true"
						v-validate="'required'"
						:error-messages="errors.collect('select')"
						:autocomplete="true"
						data-vv-name="select"
						required multiple chips>
				</v-autocomplete>
			</v-card-text>
			<v-toolbar :flat="true">
				<v-btn color="success" @click="submit">submit</v-btn>
				<v-btn color="warning" @click="clear">clear</v-btn>
			</v-toolbar>
		</v-card>
	</form>
</template>

<script>
  import {mapActions, mapGetters} from 'vuex';

  export default {
    name: "FormCreateAccount",
    mounted() {
      this.$validator.localize('en', this.dictionary)
    },
    $_veeValidate: {
      validator: 'new'
    },
    data: () => ({
      name: '',
      email: '',
      role: null,
      dictionary: {
        attributes: {
          email: 'E-mail Address'
        },
        custom: {
          name: {
            required: () => 'Name can not be empty',
            max: 'The name field may not be greater than 30 characters'
          },
          select: {
            required: 'Select field is required'
          }
        }
      }
    }),
    methods: {
      ...mapActions(['saveAccount']),
      submit() {
        this.$validator.validateAll().then(() => {
          this.saveAccount({
            username: this.name,
            email: this.email,
            roles: this.role
          })
        });
      },
      clear() {
        this.name = '';
        this.email = '';
        this.role = null;
        this.$validator.reset();
      }
    },
    computed: {
      ...mapGetters([
        'getAlert',
        'roles'
      ])
    },
    beforeCreate() {
      this.$store.dispatch("getRole");
    }
  }
</script>

<style scoped>

</style>