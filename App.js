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
import {NativeModules} from 'react-native';
const {CameraModule} = NativeModules;
export default class App extends Component {
  _openCamera() {
    CameraModule.onClick();
  }
  render() {
    return (
      <View style={{flex: 1, alignItems: 'center', justifyContent: 'center'}}>
        <Button onPress={this._openCamera} title="Open Camera" />
      </View>
    );
  }
}
