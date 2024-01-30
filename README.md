<p align="center">
    <picture>
        <source media="(prefers-color-scheme: dark)" srcset="./src/main/resources/META-INF/pluginIcon.svg" width="128">
        <source media="(prefers-color-scheme: light)" srcset="./src/main/resources/META-INF/pluginIcon_dark.svg" width="64">
        <img alt="Shows a black logo in light color mode and a white one in dark color mode." src="./src/main/resources/META-INF/pluginIcon.svg">
    </picture>
</p>
<h1 align="center">
    Relative Go To
</h1>
<h3 align="center">
    Relative Go To plugin for IntelliJ-based IDEs
</h3>
<p align="center">
  <img src="https://img.shields.io/github/license/darkyunn/relative-goto?style=for-the-badge">
  <img src="https://img.shields.io/github/stars/darkyunn/relative-goto?style=for-the-badge">
  <img src="https://img.shields.io/github/issues/darkyunn/relative-goto?color=violet&style=for-the-badge">
  <img src="https://img.shields.io/github/forks/darkyunn/relative-goto?color=teal&style=for-the-badge">
</p>

<p align="center">
  <a href="#usage" target="_blank"><img alt="undefined" src="https://img.shields.io/badge/usage-skyblue?style=for-the-badge"></a>
  <a href="#building" target="_blank"><img alt="undefined" src="https://img.shields.io/badge/building-lightgreen?style=for-the-badge"></a>
  <a href="#installation" target="_blank"><img alt="undefined" src="https://img.shields.io/badge/installation-darkviolet?style=for-the-badge"></a>
</p>


# Usage
This plugin comes with two default keybindings

1. Go `n` lines down: <kbd>Alt</kbd> + <kbd>G</kbd> - Opens a Go To dialog
2. Go `n` lines up: <kbd>Alt</kbd> + <kbd>Shift</kbd> + <kbd>G</kbd> - Opens a Go To dialog with `-` prefilled

(Note that tose keybindings can be freely modified by going to `Settings` > `Keymap` > `Plugins` > `Relative Go To`)

Positive numbers go **down** relative to the current caret position

Negative numbers go **up** relative to the current caret position

# Building

### Building on Windows
1. Run `.\gradlew.bat buildPlugin`
2. Output ZIP is directed to `build\distributions\relative-goto-VERSION.zip`

### Building on Linux
1. Run `./gradlew buildPlugin`
2. Output ZIP is directed to `build/distributions/relative-goto-VERSION.zip`

# Installation

### Manual installation
1. [Build the plugin](#building)
2. Refer to [Install plugin from disk](https://www.jetbrains.com/help/idea/managing-plugins.html#install_plugin_from_disk)

### Installation from Marketplace
You can install this plugin directly from [JetBrains Marketplace](#)

# Contributing
Feel free to create issues or pull requests on the topic of fixes

Please discuss before creating pull requests regarding new features

# Authors
- [dArkyunn](https://github.com/darkyunn) - creator of this plugin