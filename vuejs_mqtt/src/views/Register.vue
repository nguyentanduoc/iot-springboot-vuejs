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
								<v-alert :value="getAlert.isShow" :color="getAlert.color">
									{{getAlert.message}}
								</v-alert>
								<v-form>
									<v-text-field
											append-icon="person" name="login" label="Username" type="text"
											v-model="model.username">
									</v-text-field>
									<v-text-field
											append-icon="lock" name="password" label="Password" id="password" type="password"
											v-model="model.password">
									</v-text-field>
									<v-text-field
											append-icon="lock" name="confirmPassword" label="Confirm Password" id="confirmPassword"
											type="password"
											v-model="model.confirmPassword">
									</v-text-field>
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
								<v-btn block color="primary" @click="register(model)" :loading="getLoading">Register</v-btn>
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
        password: '',
        confirmPassword: ''
      }
    }),
    computed: {
      ...mapGetters([
        'getLoading',
        'getRegisterCreateSuccess',
        'getAlert',
      ])
    },
    methods: {
      ...mapActions(['register', 'resetErrored']),
    },
    updated() {
      if (this.getRegisterCreateSuccess) {
        this.$router.push('/pages/login');
      }
    },
    beforeDestroy() {
      this.resetErrored();
    }
  }
</script>

<style scoped lang="css">
	#register {
		height: 50%;
		width: 100%;
		position: absolute;
		top: 0;
		left: 0;
		content: "";
		z-index: 0;
	}
</style>