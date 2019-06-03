<template>
	<div class="home">
		<img alt="Vue logo" src="../assets/logo.png">
		<HelloWorld msg="Welcome to Your Vue.js App"/>
	</div>
</template>

<script>
  // @ is an alias to /src
  import HelloWorld from '@/components/HelloWorld.vue'

  export default {
    name: 'home',
    components: {
      HelloWorld
    },
    mqtt: {
      'test': function (val) {
        const string = new TextDecoder("utf-8").decode(val);
        this.$log.debug('test', string)
      }
    },
    beforeCreate() {
      this.$mqtt.subscribe('test')
    }
  }
</script>
