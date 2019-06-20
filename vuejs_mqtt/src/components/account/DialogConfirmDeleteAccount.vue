<template :id="$options.name">
	<v-card>
		<v-toolbar color="warning" dark flat dense cad>
			<v-toolbar-title class="subheading"> Confirm Delete Account?</v-toolbar-title>
			<v-spacer></v-spacer>
		</v-toolbar>
		<v-card-text>
			<v-alert
					:value="getAlert.isShow" :color="getAlert.color"
					v-if="getAlert.showOnComponent === $options.name">
				{{getAlert.message}}
			</v-alert>
			<v-container grid-list-md>
				<v-flex xs12>
					Do you delete account <strong>{{item.username}}</strong> ?
				</v-flex>
				<v-flex xs12>
					<v-container fluid px-0>
						<v-subheader class="pa-0">Choose Option Action?</v-subheader>
						<v-radio-group v-model="optionAction">
							<v-radio label="Disable Account" color="warning" :value="enumAction.DISABLE_ACCOUNT"></v-radio>
							<v-radio label="Always Delete" color="error" :value="enumAction.ALWAYS_DELETE"></v-radio>
						</v-radio-group>
					</v-container>
				</v-flex>
			</v-container>
		</v-card-text>
		<v-card-actions>
			<v-spacer></v-spacer>
			<v-btn color="error" @click="onApply">
				Apply
			</v-btn>
			<v-btn color="success" @click="$emit('closeDialogConfirmDelete')">
				Cancel
			</v-btn>
		</v-card-actions>
	</v-card>
</template>

<script>
  import {mapActions, mapGetters} from 'vuex';
  import actionDelete from '../../common/enum/deleteAction';

  export default {
    name: "DialogConfirmDeleteAccount",
    props: ['item'],
    data() {
      return {
        optionAction: actionDelete.DISABLE_ACCOUNT,
        enumAction: actionDelete
      }
    },
    computed: {
      ...mapGetters(['getAlert'])
    },
    methods: {
      ...mapActions(['deleteAccount']),
      onApply() {
        this.deleteAccount({
          componentName: this.$options.name,
          item: this.item,
          optionAction: this.optionAction
        });
      }
    }
  }
</script>

<style scoped>

</style>