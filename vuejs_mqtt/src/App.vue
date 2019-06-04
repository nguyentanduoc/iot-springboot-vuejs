<template>
	<div id="app">
		<div id="nav">
			<router-link to="/">Home</router-link>
			|
			<router-link to="/about">About</router-link>
			|
			<router-link to="/map">Map</router-link>
			|
			<router-link to="/map-leaflet">Vue2Leaflet</router-link>
			|
			<router-link to="/basic">Basic</router-link>
			|
			<router-link to="/implement-map">implement-map</router-link>
			|
			<router-link to="/vuelayers">vue layers</router-link>
			|
		</div>
		<router-view/>
	</div>
</template>

<style>
	#nav {
		padding: 30px;
	}

	#nav a {
		font-weight: bold;
		color: #2c3e50;
	}

	#nav a.router-link-exact-active {
		color: #42b983;
	}
</style>
