/**
 * @file Source code generated by PDL compiler.
 */
/// <reference path="../../TypeReferences.d.ts" />
/// <amd-dependency path="../../Resource/Settings/ViewModels/SettingsBladeViewModel" />
/// <amd-dependency path="../../Resource/Settings/ViewModels/SettingsPartViewModel" />
define(["require", "exports", "../../Resource/Settings/ViewModels/SettingsBladeViewModel", "../../Resource/Settings/ViewModels/SettingsPartViewModel"], function (require, exports) {
    var Main;
    (function (Main) {
        "use strict";
        Main.blade = {
            "name": "SettingsBlade",
            "inputs": [
                "id"
            ],
            "viewModelName": "Resource$SettingsBladeViewModel",
            "lenses": [
                {
                    "name": "SettingListLens",
                    "partInstances": [
                        {
                            "name": "SettingListPart",
                            "inline": {
                                "viewModel": "Resource$SettingsPartViewModel",
                                "partKind": 0,
                                "inputs": [
                                    "id"
                                ],
                                "bindings": [
                                    {
                                        "property": "id",
                                        "valuesFrom": [
                                            {
                                                "referenceType": 1,
                                                "property": "id"
                                            }
                                        ]
                                    }
                                ],
                                "htmlTemplate": "pdc4b010fc07dd345dd8f3cdc4bb270df2b",
                                "details": [
                                    {
                                        "invocationInputArguments": [
                                            {
                                                "valuesFrom": [
                                                    {
                                                        "referenceType": 0,
                                                        "property": "content.settingList.selectableData"
                                                    }
                                                ]
                                            }
                                        ]
                                    }
                                ],
                                "initialSize": 8,
                                "supportedSizes": [
                                    8
                                ],
                                "viewStateProperties": [
                                    "content.settingList.selectableData.activatedItems",
                                    "content.settingList.selectableData.selectedItems"
                                ]
                            }
                        }
                    ]
                }
            ],
            "viewModelInputs": [
                {
                    "property": "id",
                    "valuesFrom": [
                        {
                            "referenceType": 1,
                            "property": "id"
                        }
                    ]
                }
            ],
            "width": 0,
            "locked": true,
            "style": 11
        };
    })(Main || (Main = {}));
    return Main;
});
