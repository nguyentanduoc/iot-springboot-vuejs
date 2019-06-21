<template >
	<v-app :id="$options.name" class="primary">
		<v-content>
			<v-container fluid fill-height>
				<v-layout align-center justify-center>
					<v-flex xs12 sm8 md4 lg4>
						<v-card class="elevation-1 pa-3">
							<v-card-text>
								<div class="layout column align-center">
									<img src="/static/tracking-icon.svg" alt="tracking-icon" width="120" height="120">
									<h1 class="flex my-4 primary--text">Vehicle Management with IoT</h1>
								</div>
								<v-form @submit.prevent="login(model)">
									<v-alert
											:value="getAlert.isShow" :color="getAlert.color"
											v-if="getAlert.showOnComponent === $options.name">
										{{getAlert.message}}
									</v-alert>
									<v-text-field
											append-icon="person" name="login" label="Login" type="text"
											v-model="model.username"></v-text-field>
									<v-text-field
											append-icon="lock" name="password" label="Password" id="password" type="password"
											v-model="model.password"></v-text-field>
								</v-form>
								<router-link to="/pages/register">
									<a>Create Account</a>
								</router-link>
							</v-card-text>
							<v-card-actions>
								<!--								<v-btn icon>-->
								<!--									<v-icon color="blue">fa fa-facebook-square fa-lg</v-icon>-->
								<!--								</v-btn>-->
								<!--								<v-btn icon>-->
								<!--									<v-icon color="red">fa fa-google fa-lg</v-icon>-->
								<!--								</v-btn>-->
								<!--								<v-btn icon>-->
								<!--									<v-icon color="light-blue">fa fa-twitter fa-lg</v-icon>-->
								<!--								</v-btn>-->
								<v-spacer></v-spacer>
								<v-btn block color="primary" @click="login(model)" :loading="getLoading">Login</v-btn>
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
    name: 'Login',
    data: () => ({
      model: {
        username: 'admin',
        password: '12345678'
      }
    }),
    computed: {
      ...mapGetters([
        'getLoading',
        'getIsLogin',
        'getAlert'
      ])
    },
    methods: {
      ...mapActions(['login', 'resetErrored']),
    },
    updated() {
      if (this.getIsLogin.isLogin && this.getIsLogin.isLogin.jwt !== '') {
        this.$router.push('/home');
      }
    },
    beforeDestroy() {
      this.resetErrored();
    }
  };
</script>
<style scoped lang="css">
	#Login {
		height: 50%;
		width: 100%;
		position: absolute;
		top: 0;
		left: 0;
		content: "";
		z-index: 0;
	}
</style>
