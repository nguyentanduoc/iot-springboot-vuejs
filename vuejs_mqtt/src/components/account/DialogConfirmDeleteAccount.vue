<template>
	<v-card>
		<v-toolbar color="warning" dark flat dense cad>
			<v-toolbar-title class="subheading"> Confirm Delete Account?</v-toolbar-title>
			<v-spacer></v-spacer>
		</v-toolbar>
		<v-card-text>
			<v-container grid-list-md>
				<v-flex xs12>
					Do you delete account <strong>{{item.username}}</strong> ?
				</v-flex>
				<v-flex xs12>
					<v-container fluid px-0>
						<v-subheader class="pa-0">Choose Option?</v-subheader>
						<v-radio-group v-model="radioGroup">
							<v-radio label="Disable Account" color="warning" value="disable-account"></v-radio>
							<v-radio label="Always Delete" color="error" value="always-delete"></v-radio>
						</v-radio-group>
					</v-container>
				</v-flex>
			</v-container>
		</v-card-text>
		<v-card-actions>
			<v-spacer></v-spacer>
			<v-btn color="error" @click="save">
				Apply
			</v-btn>
			<v-btn color="success" @click="$emit('closeDialogConfirmDelete')">
				Cancel
			</v-btn>
		</v-card-actions>
	</v-card>
</template>

<script>
  export default {
    name: "DialogConfirmDeleteAccount",
    props: ['item'],
    data() {
      return {
        radioGroup: 'disable-account'
      }
    }
  }
</script>

<style scoped>

</style>