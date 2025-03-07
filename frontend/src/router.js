
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import MemberMemberManager from "./components/listers/MemberMemberCards"
import MemberMemberDetail from "./components/listers/MemberMemberDetail"

import MemberInfoView from "./components/MemberInfoView"
import MemberInfoViewDetail from "./components/MemberInfoViewDetail"
import DeviceDeviceManager from "./components/listers/DeviceDeviceCards"
import DeviceDeviceDetail from "./components/listers/DeviceDeviceDetail"

import DeviceInfoView from "./components/DeviceInfoView"
import DeviceInfoViewDetail from "./components/DeviceInfoViewDetail"
import LostLostManager from "./components/listers/LostLostCards"
import LostLostDetail from "./components/listers/LostLostDetail"

import LostInfoView from "./components/LostInfoView"
import LostInfoViewDetail from "./components/LostInfoViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/members/members',
                name: 'MemberMemberManager',
                component: MemberMemberManager
            },
            {
                path: '/members/members/:id',
                name: 'MemberMemberDetail',
                component: MemberMemberDetail
            },

            {
                path: '/members/memberInfos',
                name: 'MemberInfoView',
                component: MemberInfoView
            },
            {
                path: '/members/memberInfos/:id',
                name: 'MemberInfoViewDetail',
                component: MemberInfoViewDetail
            },
            {
                path: '/devices/devices',
                name: 'DeviceDeviceManager',
                component: DeviceDeviceManager
            },
            {
                path: '/devices/devices/:id',
                name: 'DeviceDeviceDetail',
                component: DeviceDeviceDetail
            },

            {
                path: '/devices/deviceInfos',
                name: 'DeviceInfoView',
                component: DeviceInfoView
            },
            {
                path: '/devices/deviceInfos/:id',
                name: 'DeviceInfoViewDetail',
                component: DeviceInfoViewDetail
            },
            {
                path: '/losts/losts',
                name: 'LostLostManager',
                component: LostLostManager
            },
            {
                path: '/losts/losts/:id',
                name: 'LostLostDetail',
                component: LostLostDetail
            },

            {
                path: '/losts/lostInfos',
                name: 'LostInfoView',
                component: LostInfoView
            },
            {
                path: '/losts/lostInfos/:id',
                name: 'LostInfoViewDetail',
                component: LostInfoViewDetail
            },


    ]
})
