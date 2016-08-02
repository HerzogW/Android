/**
 * @file Source code generated by PDL compiler.
 * @version 1.0
 * @sdkversion 5.0.302.319 (production_sdk#058d65f.160330-1230)
 * @schemaversion 1.0.0.2
 */
/// <reference path="../TypeReferences.d.ts" />
/// <amd-bundling root="true" priority="0" />
define(["require", "exports", "./../_generated/SvgLogo", "ClientResources"], function (require, exports, SvgLogo, ClientResources) {
    var ExtensionDefinition;
    (function (ExtensionDefinition) {
        "use strict";
        var untypedManifest = {
            "name": "Microsoft_Azure_ProjectOxford",
            "version": "1.0",
            "schemaVersion": "1.0.0.2",
            "sdkVersion": "5.0.302.319 (production_sdk#058d65f.160330-1230)",
            "isPreview": true,
            "notifications": [],
            "assetTypes": [
                {
                    "name": "ApiAccount",
                    "singularDisplayName": ClientResources.AssetTypeNames.Resource.singular,
                    "pluralDisplayName": ClientResources.AssetTypeNames.Resource.plural,
                    "lowerSingularDisplayName": ClientResources.AssetTypeNames.Resource.lowerSingular,
                    "lowerPluralDisplayName": ClientResources.AssetTypeNames.Resource.lowerPlural,
                    "viewModel": "Browse$AssetTypeViewModel",
                    "contracts": 6,
                    "partName": "ResourcePart",
                    "bladeName": "ResourceBlade",
                    "browseType": 1,
                    "privateBrowse": true,
                    "resourceType": {
                        "resourceTypeName": "Microsoft.ProjectOxford/accounts",
                        "apiVersion": null
                    },
                    "icon": SvgLogo.Content.SVG.projectOxford2,
                    "marketplaceItemId": "Microsoft.OxfordPackage"
                },
                {
                    "name": "CognitiveServicesAccount",
                    "singularDisplayName": ClientResources.CognitiveServices.AssetTypeNames.Resource.singular,
                    "pluralDisplayName": ClientResources.CognitiveServices.AssetTypeNames.Resource.plural,
                    "lowerSingularDisplayName": ClientResources.CognitiveServices.AssetTypeNames.Resource.lowerSingular,
                    "lowerPluralDisplayName": ClientResources.CognitiveServices.AssetTypeNames.Resource.lowerPlural,
                    "viewModel": "Browse$AssetTypeViewModel",
                    "contracts": 6,
                    "partName": "CognitiveServicesResourcePart",
                    "bladeName": "ResourceBlade",
                    "browseType": 1,
                    "resourceType": {
                        "resourceTypeName": "Microsoft.CognitiveServices/accounts",
                        "apiVersion": null
                    },
                    "icon": SvgLogo.Content.SVG.cognitiveServices2,
                    "marketplaceItemId": "Microsoft.CognitiveServices"
                }
            ],
            "notifications2": [],
            "startBoardParts": [],
            "blades": [
                {
                    "name": "PropertiesBlade",
                    "width": 0
                },
                {
                    "name": "ApiAccountSpecPicker",
                    "width": 1,
                    "extensionHints": [
                        "HubsExtension"
                    ]
                },
                {
                    "name": "KeySettingBlade",
                    "width": 0
                },
                {
                    "name": "CreateBlade",
                    "width": 0
                },
                {
                    "name": "CreationLegalBlade"
                },
                {
                    "name": "CognitiveServicesApiType",
                    "width": 2
                },
                {
                    "name": "ResourceBlade"
                },
                {
                    "name": "QuickStartBlade",
                    "width": 1
                },
                {
                    "name": "SettingsBlade",
                    "width": 0
                },
                {
                    "name": "BlankBlade"
                },
                {
                    "name": "OxfordCreateBlade",
                    "width": 0
                },
                {
                    "name": "ProjectOxfordApiType",
                    "width": 2
                }
            ],
            "galleryParts": [
                {
                    "name": "EventsSummaryPart",
                    "initialSize": 2,
                    "partGalleryInfo": {
                        "title": ClientResources.ResourceBlade.eventsInThePastWeekLauncherPartTitle,
                        "category": ClientResources.ResourceBlade.lensOperationsTitle,
                        "thumbnail": MsPortalFx.Base.Images.Polychromatic.Log(),
                        "thumbnailStretch": 0,
                        "pivotKind": 2
                    },
                    "assetType": "CognitiveServicesAccount",
                    "inputDefinitions": [
                        {
                            "name": "id",
                            "type": "MsPortalFx.ViewModels.ResourceId",
                            "optional": false,
                            "isAssetId": true
                        }
                    ]
                },
                {
                    "name": "PricingTierPart",
                    "initialSize": 3,
                    "partGalleryInfo": {
                        "title": ClientResources.ResourceBlade.pricingTierPartTitle,
                        "category": ClientResources.ResourceBlade.lensUsageTitle,
                        "thumbnail": MsPortalFx.Base.Images.Polychromatic.BillingHub(),
                        "thumbnailStretch": 0,
                        "pivotKind": 2
                    },
                    "assetType": "CognitiveServicesAccount",
                    "inputDefinitions": [
                        {
                            "name": "id",
                            "type": "MsPortalFx.ViewModels.ResourceId",
                            "optional": false,
                            "isAssetId": true
                        }
                    ]
                }
            ]
        };
        untypedManifest.pageVersion = window.fx.environment.pageVersion;
        ExtensionDefinition.manifest = untypedManifest;
        MsPortalFx.Extension.registerAmd(ExtensionDefinition.manifest, "Program", require);
    })(ExtensionDefinition || (ExtensionDefinition = {}));
    return ExtensionDefinition;
});
