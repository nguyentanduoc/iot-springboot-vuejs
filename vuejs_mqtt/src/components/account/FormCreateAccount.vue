<template>
	<form>
		<v-card>
			<v-toolbar :flat="true">
				<v-toolbar-title>Create Account</v-toolbar-title>
			</v-toolbar>
			<v-card-text>
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
				<multiselect
						:multiple="true"
						v-model="select"
						:options="items">
				</multiselect>
				<v-checkbox
						v-model="checkbox"
						v-validate="'required'"
						:error-messages="errors.collect('checkbox')"
						value="1"
						label="Option"
						data-vv-name="checkbox"
						type="checkbox"
						required
				></v-checkbox>
			</v-card-text>
			<v-toolbar :flat="true">
				<v-btn color="success" @click="submit">submit</v-btn>
				<v-btn color="warning" @click="clear">clear</v-btn>
			</v-toolbar>
		</v-card>
	</form>
</template>

<script>
  import Multiselect from 'vue-multiselect';

  export default {
    name: "FormCreateAccount",
    components: {
      Multiselect
    },
    mounted() {
      this.$validator.localize('en', this.dictionary)
    },
    $_veeValidate: {
      validator: 'new'
    },
    data: () => ({
      name: '',
      email: '',
      select: null,
      items: [
        'Item 1',
        'Item 2',
        'Item 3',
        'Item 4'
      ],
      checkbox: null,
      dictionary: {
        attributes: {
          email: 'E-mail Address'
        },
        custom: {
          name: {
            required: () => 'Name can not be empty',
            max: 'The name field may not be greater than 10 characters'
          },
          select: {
            required: 'Select field is required'
          }
        }
      }
    }),
    methods: {
      submit() {
        this.$validator.validateAll()
      },
      clear() {
        this.name = '';
        this.email = '';
        this.select = null;
        this.checkbox = null;
        this.$validator.reset();
      }
    }
  }
</script>

<style scoped>

</style>