<template :id="$options.name">
	<div>
		<div>Out Side</div>
		<router-view></router-view>
	</div>
</template>

<script>
  export default {
    name: "OutSideLayout"
  }
</script>

<style scoped>

</style>