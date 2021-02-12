/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {Component} from 'react';
import {View} from 'react-native';
import {Button} from 'react-native';
import {
  NativeModules,
  NativeEventEmitter,
  DeviceEventEmitter,
} from 'react-native';
const {CameraModule} = NativeModules;
export default class App extends Component {
  _openCamera() {
    CameraModule.onClick();
  }
  _sendEvent() {
    const eventEmitter = new NativeEventEmitter(CameraModule.sendEvent);
    var abc = eventEmitter.addListener('customEventName', (event) => {
      console.log('eee', event)// "someValue"
   });
   console.log(abc);
  }
  render() {
    return (
      <View style={{flex: 1, alignItems: 'center', justifyContent: 'center'}}>
        <Button onPress={this._openCamera} title="Open Camera" />
        <Button onPress={this._sendEvent} title="send Event" />
      </View>
    );
  }
}
