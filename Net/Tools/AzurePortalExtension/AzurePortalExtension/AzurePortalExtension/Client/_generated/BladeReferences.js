/**
 * @file Source code generated by PDL compiler.
 * @version 1.0
 * @sdkversion 5.0.302.329 (production_sdk#b7c08d1.160414-1450)
 * @schemaversion 1.0.0.2
 */
/// <reference path="../TypeReferences.d.ts" />
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports"], function (require, exports) {
    var BladeDefinitions;
    (function (BladeDefinitions) {
        var extensionName = "AzurePortalExtension";
        var PropertiesBladeReference = (function (_super) {
            __extends(PropertiesBladeReference, _super);
            function PropertiesBladeReference(inputs) {
                _super.call(this, "PropertiesBlade", inputs, undefined, undefined, extensionName);
            }
            return PropertiesBladeReference;
        })(MsPortalFx.Composition.PdlBladeReference);
        BladeDefinitions.PropertiesBladeReference = PropertiesBladeReference;
        var ResourceBladeReference = (function (_super) {
            __extends(ResourceBladeReference, _super);
            function ResourceBladeReference(inputs) {
                _super.call(this, "ResourceBlade", inputs, undefined, undefined, extensionName);
            }
            return ResourceBladeReference;
        })(MsPortalFx.Composition.PdlBladeReference);
        BladeDefinitions.ResourceBladeReference = ResourceBladeReference;
        var QuickStartBladeReference = (function (_super) {
            __extends(QuickStartBladeReference, _super);
            function QuickStartBladeReference() {
                _super.call(this, "QuickStartBlade", undefined, undefined, undefined, extensionName);
            }
            return QuickStartBladeReference;
        })(MsPortalFx.Composition.PdlBladeReference);
        BladeDefinitions.QuickStartBladeReference = QuickStartBladeReference;
        var SettingsBladeReference = (function (_super) {
            __extends(SettingsBladeReference, _super);
            function SettingsBladeReference(inputs) {
                _super.call(this, "SettingsBlade", inputs, undefined, undefined, extensionName);
            }
            return SettingsBladeReference;
        })(MsPortalFx.Composition.PdlBladeReference);
        BladeDefinitions.SettingsBladeReference = SettingsBladeReference;
        var CreateBladeReference = (function (_super) {
            __extends(CreateBladeReference, _super);
            function CreateBladeReference(options) {
                _super.call(this, options, "CreateBlade", undefined, extensionName);
            }
            return CreateBladeReference;
        })(MsPortalFx.Composition.ParameterProviderBladeReference);
        BladeDefinitions.CreateBladeReference = CreateBladeReference;
    })(BladeDefinitions || (BladeDefinitions = {}));
    return BladeDefinitions;
});