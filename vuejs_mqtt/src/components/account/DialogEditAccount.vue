<template>
	<v-card>
		<v-toolbar card dense color="transparent">
			<v-toolbar-title><h4>Edit Account</h4></v-toolbar-title>
			<v-spacer></v-spacer>
		</v-toolbar>
		<v-divider></v-divider>
		<v-card-text>
			<v-alert
					:value="getAlert.isShow" :color="getAlert.color"
					v-if="getAlert.showOnComponent === $options.name">
				{{getAlert.message}}
			</v-alert>
			<v-container grid-list-md>
				<v-layout wrap>
					<v-flex xs12>
						<v-text-field label="Full Name*" required v-model="item.username"></v-text-field>
					</v-flex>
					<v-flex xs12>
						<v-text-field label="Email*" required v-model="item.email"></v-text-field>
					</v-flex>
					<v-flex xs12>
						<v-autocomplete
								v-model="item.roleIds"
								:items="roles"
								label="Roles"
								item-text="name"
								item-value="id"
								:deletable-chips="true"
								multiple required chips
						></v-autocomplete>
					</v-flex>
				</v-layout>
			</v-container>
		</v-card-text>
		<v-card-actions>
			<v-spacer></v-spacer>
			<v-btn color="blue darken-1" flat @click="$emit('closeDialog')">Close</v-btn>
			<v-btn color="blue darken-1" flat @click="editAccount(item)">Save</v-btn>
		</v-card-actions>
	</v-card>
</template>

<script>
  import {mapGetters, mapActions} from 'vuex';

  export default {
    name: "DialogEditAccount",
    props: ['item'],
    computed: {
      ...mapGetters(['accounts', 'roles', 'getAlert']),
    },
    methods: {
      ...mapActions(['editAccount']),
    }
  }
</script>

<style scoped>

</style>