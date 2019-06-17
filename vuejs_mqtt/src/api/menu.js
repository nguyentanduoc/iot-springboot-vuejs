const Menu = [
  {header: 'Apps'},
  {
    title: 'Dashboard',
    group: 'apps',
    icon: 'dashboard',
    name: 'Dashboard',
    href: '/home'
  },
  {
    title: 'Map',
    group: 'apps',
    icon: 'map',
    name: 'Map',
    href: '/map'
  },
  {divider: true},
  {header: 'Extras'},
  {
    title: 'Pages',
    group: 'extra',
    icon: 'list',
    items: [
      {name: 'Login', title: 'Login', href: '/pages/login'},
      {name: '404', title: 'Not Found', href: '/pages/404'},
      {name: '403', title: 'Access Denied', href: '/pages/403'},
      {name: '500', title: 'Server Internal Error', href: '/pages/500'},
    ]
  },
];
// reorder menu
Menu.forEach((item) => {
  if (item.items) {
    item.items.sort((x, y) => {
      let textA = x.title.toUpperCase();
      let textB = y.title.toUpperCase();
      return (textA < textB) ? -1 : (textA > textB) ? 1 : 0;
    });
  }
});

export default Menu;
