<template :id="$options.name">
	<v-navigation-drawer v-model="drawer" fixed app>
		<v-list dense>
			<v-list-tile
					v-for="(link, i) in links"
					:key="i"
					:to="link.to"
					avatar
					class="v-list-item">
				<v-list-tile-action>
					<v-icon>{{ link.icon }}</v-icon>
				</v-list-tile-action>
				<v-list-tile-title v-text="link.text"/>
			</v-list-tile>
		</v-list>
	</v-navigation-drawer>
</template>

<script>
  export default {
    name: "Header",
    color: 'success',
    data: () => ({
      drawer: null,
      links: [
        {
          to: '/home',
          icon: 'home',
          text: 'Home'
        },
        {
          to: '/map',
          icon: 'map',
          text: 'Map'
        }
      ]
    }),
  }
</script>

<style scoped>

</style>