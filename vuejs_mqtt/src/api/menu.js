const Menu = [
  {
    "id": 1,
    "name": "",
    "title": "",
    "icon": "",
    "href": "",
    "header": "Apps",
    "isDriver": false,
    "groupMenuModel": {
      "id": 1,
      "name": "Apps"
    },
    "sortNum": 0
  },
  {
    "id": 2,
    "name": "Dashboard",
    "title": "Dashboard",
    "icon": "dashboard",
    "href": "/home",
    "header": "",
    "isDriver": false,
    "groupMenuModel": {
      "id": 1,
      "name": "Apps"
    },
    "sortNum": 1
  },
  {
    "id": 3,
    "name": "Map",
    "title": "Map",
    "icon": "map",
    "href": "/map",
    "header": "",
    "isDriver": false,
    "groupMenuModel": {
      "id": 1,
      "name": "Apps"
    },
    "sortNum": 2
  },
  {
    "id": 4,
    "name": "",
    "title": "",
    "icon": "",
    "href": "",
    "header": "",
    "isDriver": true,
    "groupMenuModel": {
      "id": 2,
      "name": "Management"
    },
    "sortNum": 100
  },
  {
    "id": 5,
    "name": "",
    "title": "",
    "icon": "",
    "href": "",
    "header": "Management",
    "isDriver": false,
    "groupMenuModel": {
      "id": 2,
      "name": "Management"
    },
    "sortNum": 102
  },
  {
    "id": 6,
    "name": "Account",
    "title": "Account",
    "icon": "account_circle",
    "href": "/account",
    "header": "",
    "isDriver": false,
    "groupMenuModel": {
      "id": 2,
      "name": "Management"
    },
    "sortNum": 103
  },
  {
    "id": 7,
    "name": "Sensor",
    "title": "Sensor",
    "icon": "memory",
    "href": "/sensor",
    "header": "",
    "isDriver": false,
    "groupMenuModel": {
      "id": 2,
      "name": "Management"
    },
    "sortNum": 104
  },
  {
    "id": 8,
    "name": "TypeOfSensor",
    "title": "Type Of Sensor",
    "icon": "memory",
    "href": "/type-of-sensor",
    "header": "",
    "isDriver": false,
    "groupMenuModel": {
      "id": 2,
      "name": "Management"
    },
    "sortNum": 105
  }
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
