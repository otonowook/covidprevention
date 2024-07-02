
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import HealthcenterReserveManager from "./components/listers/HealthcenterReserveCards"
import HealthcenterReserveDetail from "./components/listers/HealthcenterReserveDetail"

import IsolationcampIsolationCampManager from "./components/listers/IsolationcampIsolationCampCards"
import IsolationcampIsolationCampDetail from "./components/listers/IsolationcampIsolationCampDetail"

import DeliverycenterDeliveryManager from "./components/listers/DeliverycenterDeliveryCards"
import DeliverycenterDeliveryDetail from "./components/listers/DeliverycenterDeliveryDetail"


import TestingcenterTestManager from "./components/listers/TestingcenterTestCards"
import TestingcenterTestDetail from "./components/listers/TestingcenterTestDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/healthcenters/reserves',
                name: 'HealthcenterReserveManager',
                component: HealthcenterReserveManager
            },
            {
                path: '/healthcenters/reserves/:id',
                name: 'HealthcenterReserveDetail',
                component: HealthcenterReserveDetail
            },

            {
                path: '/isolationcamps/isolationCamps',
                name: 'IsolationcampIsolationCampManager',
                component: IsolationcampIsolationCampManager
            },
            {
                path: '/isolationcamps/isolationCamps/:id',
                name: 'IsolationcampIsolationCampDetail',
                component: IsolationcampIsolationCampDetail
            },

            {
                path: '/deliverycenters/deliveries',
                name: 'DeliverycenterDeliveryManager',
                component: DeliverycenterDeliveryManager
            },
            {
                path: '/deliverycenters/deliveries/:id',
                name: 'DeliverycenterDeliveryDetail',
                component: DeliverycenterDeliveryDetail
            },


            {
                path: '/testingcenters/tests',
                name: 'TestingcenterTestManager',
                component: TestingcenterTestManager
            },
            {
                path: '/testingcenters/tests/:id',
                name: 'TestingcenterTestDetail',
                component: TestingcenterTestDetail
            },



    ]
})
