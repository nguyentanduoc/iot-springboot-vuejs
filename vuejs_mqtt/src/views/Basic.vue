<template>
	<div>
		<p>{{message}}</p>
		<div></div>
		<div>
			<button @click="reverseMessage">reverse message</button>
		</div>
		<label>
			<input v-model="message"/>
		</label>
		<div>
			{{now}}
		</div>
		<div>
			<div>
				<label>
					<input v-model="firstName">
				</label>
			</div>
			<div>
				<label>
					<input v-model="lastName">
				</label>
			</div>
			<div>
				{{fullName}}
			</div>
			<button @click="logFullName">Log Full Name</button>
		</div>
		<Basic1>
			<div>Ok OKo</div>
		</Basic1>
	</div>
</template>

<script>
  import Basic1 from './Basic1';

  export default {
    name: "Basic",
    components: {Basic1},
    data() {
      return {
        message: "hello Baby",
        firstName: "",
        lastName: ""
      }
    },
    methods: {
      reverseMessage() {
        let message = this.message;
        this.message = message.split('').reverse().join('');
      },
      logFullName() {
        this.$log.debug(this.fullName);
      }
    },
    computed: {
      now: function () {
        return Date.now();
      },
      fullName: function () {
        return this.firstName.trim() + " " + this.lastName.trim();
      }
    }
  }
</script>

<style scoped>

</style>