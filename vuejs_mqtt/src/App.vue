<template>
	<router-view></router-view>
</template>
<script>
  import colors from 'vuetify/es5/util/colors';

  export default {
    name: "App",
    data() {
      return {
        colors: colors
      }
    },
    mounted() {
      this.$vuetify.theme.primary = this.colors['indigo'].base;
    }
  }
</script>
<style>
</style>
