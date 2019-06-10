<template>
	<v-app id="register" class="primary">
		<v-content>
			<v-container fluid fill-height>
				<v-layout align-center justify-center>
					<v-flex xs12 sm8 md4 lg4>
						<v-card class="elevation-1 pa-3">
							<v-card-text>
								<div class="layout column align-center">
									<img src="/static/m.png" alt="Vue Material Admin" width="120" height="120">
									<h1 class="flex my-4 primary--text">IoT Register</h1>
								</div>
								<v-alert
										:value="getIsErrored"
										color="error">
									{{getMessageError}}
								</v-alert>
								<v-form>
									<v-text-field
											append-icon="person" name="login" label="Username" type="text"
											v-model="model.username"></v-text-field>
									<v-text-field
											append-icon="lock" name="password" label="Password" id="password" type="password"
											v-model="model.password"></v-text-field>
								</v-form>
							</v-card-text>
							<v-card-actions>
								<v-btn icon>
									<v-icon color="blue">fa fa-facebook-square fa-lg</v-icon>
								</v-btn>
								<v-btn icon>
									<v-icon color="red">fa fa-google fa-lg</v-icon>
								</v-btn>
								<v-btn icon>
									<v-icon color="light-blue">fa fa-twitter fa-lg</v-icon>
								</v-btn>
								<v-spacer></v-spacer>
								<v-btn block color="primary" @click="onRegister" :loading="getIsLogin">Login</v-btn>
							</v-card-actions>
						</v-card>
					</v-flex>
				</v-layout>
			</v-container>
		</v-content>
	</v-app>
</template>

<script>
  import {mapActions, mapGetters} from 'vuex'

  export default {
    name: "Register",
    data: () => ({
      loading: false,
      model: {
        username: '',
        password: ''
      }
    }),
    computed: {
      ...mapGetters([
        'getIsLogin',
        'getCreateSuccess',
        'getMessageError',
        'getIsErrored'
      ])
    },
    mounted() {

    },
    methods: {
      ...mapActions(['register']),
      async onRegister() {
        await this.register(this.model);
        if (this.getCreateSuccess) {
          this.$router.push('/pages/login');
        }
      }
    }
  }
</script>

<style scoped>

</style>