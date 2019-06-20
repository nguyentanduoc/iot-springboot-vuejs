<template>
	<div :id="$options.name">
		<v-card>
			<v-toolbar card dense color="transparent">
				<v-toolbar-title><h4>Table User</h4></v-toolbar-title>
				<v-spacer></v-spacer>
				<v-btn icon>
					<v-icon @click="getAccount">refresh</v-icon>
				</v-btn>
			</v-toolbar>
			<v-divider></v-divider>
			<v-card-text v-if="accounts">
				<v-alert
						:value="getAlert.isShow" :color="getAlert.color"
						v-if="getAlert.showOnComponent === $options.name">
					{{getAlert.message}}
				</v-alert>
				<v-data-table
						class="elevation-1"
						:headers="headers"
						:items="accounts.content"
						:loading="!accounts"
						hide-actions>
					<template v-slot:items="props">
						<td class="text-xs-left">{{ props.item.username }}</td>
						<td class="text-xs-left">{{ props.item.email }}</td>
						<td class="text-xs-left">
							<v-chip
									:color="props.item.enabled ? 'green' : 'red'"
									text-color="white"
									label small>
								{{props.item.enabled ? 'enabled' : 'disabled'}}
							</v-chip>
						</td>
						<td class="justify-center px-0">
							<v-btn depressed outline icon fab dark color="primary" small @click="editItem(props.item)">
								<v-icon>edit</v-icon>
							</v-btn>
							<v-btn depressed outline icon fab dark color="pink" small @click="deleteItem(props.item)">
								<v-icon>delete</v-icon>
							</v-btn>
						</td>
					</template>
				</v-data-table>
				<div class="text-xs-center pt-3">
					<v-pagination
							@input="pageClick"
							:value="accounts.number + 1"
							:length="accounts.totalPages"
							:total-visible="7"
							circle
							prev-icon="keyboard_arrow_left"
							next-icon="keyboard_arrow_right"
					></v-pagination>
				</div>
			</v-card-text>
		</v-card>
		<v-dialog v-model="dialog" persistent max-width="600px">
			<dialog-edit-account
					v-if="dialog && itemEdit"
					:item="itemEdit"
					@closeDialog="dialog = false"/>
		</v-dialog>
		<v-dialog v-model="dialogConfirmDelete" max-width="320">
			<dialog-confirm-delete-account
					v-if="dialogConfirmDelete && itemDelete"
					:item="itemDelete"
					@closeDialogConfirmDelete="dialogConfirmDelete = false"/>
		</v-dialog>
	</div>
</template>

<script>
  import {mapGetters, mapActions} from 'vuex'
  import DialogEditAccount from "./DialogEditAccount";
  import DialogConfirmDeleteAccount from './DialogConfirmDeleteAccount';

  export default {
    name: "ListAccount",
    components: {
      DialogEditAccount,
      DialogConfirmDeleteAccount
    },
    data() {
      return {
        headers: [
          {text: 'Username', align: 'left', value: 'username'},
          {text: 'Email', value: 'email'},
          {text: 'Enabled', value: 'enabled'},
          {text: 'Actions', value: 'name', sortable: false, align: 'center',}
        ],
        dialog: false,
        itemEdit: null,
        dialogConfirmDelete: false,
        itemDelete: null
      }
    },
    beforeCreate() {
      this.$store.dispatch("getAccount");
    },
    computed: {
      ...mapGetters(['accounts', 'roles', "getAlert"])
    },
    methods: {
      ...mapActions(['getAccount']),
      editItem(item) {
        this.dialog = true;
        this.itemEdit = {...item};
      },
      deleteItem(item) {
        this.dialogConfirmDelete = true;
        this.itemDelete = {...item};
      },
      pageClick(page) {
        this.getAccount({page: page - 1});
      }
    },
  }
</script>

<style scoped>

</style>