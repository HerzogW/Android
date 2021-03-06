/// <amd-bundling root="true" />

export = ProjectOxfordExtension;
module ProjectOxfordExtension {
    "use strict";
    const repeatingFragment = " class='msportalfx-svg-placeholder' role='img' xmlns:svg='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'><title></title>";
    const _commonViewBox50 = "0 0 50 50";
    const _commonViewBox16 = "0 0 16 16";
    const _msportalfxSvgColorClass = " class='msportalfx-svg-c";
    const _enableBackgroundNew = " enable-background='new '";
    const _polygonPoint = "<polygon points='";
    const createSvgImage = FxImpl.DefinitionBuilder.createSvgImage;
    function _setData(data: StringMap<MsPortalFx.Base.Image>, resources: any[][]){
        resources.forEach((v) =>{
            data[v[0]] = createSvgImage(v[1], v[2]);
        });
    }
    function _svgViewBox(viewbox: string, content: string){
        return `<svg viewBox='${viewbox}'${repeatingFragment}${content}</svg>`;
    }
    function _widthHeightAttribs(width: number, height: number){
        return ` width='${width}' height='${height}'`;
    }
    function _rectXY(x: number, y: number){
        return `<rect x='${x}' y='${y}'`;
    }
    function _pathOpacity(x: number){
        return `<path opacity='${x}'`;
    }
    function _circleCxCyR(cx: number, cy: number, r: number){
        return `<circle cx='${cx}' cy='${cy}' r='${r}'`;
    }
    export module Content {
        export module SVG {
            export declare const projectOxford: MsPortalFx.Base.Image;
            export declare const regenerateKeyOne: MsPortalFx.Base.Image;
            export declare const regenerateKeyTwo: MsPortalFx.Base.Image;
            export declare const sampleA: MsPortalFx.Base.Image;
            export declare const sampleB: MsPortalFx.Base.Image;
            export declare const sampleC: MsPortalFx.Base.Image;
            export declare const sampleD: MsPortalFx.Base.Image;
            export declare const sampleE: MsPortalFx.Base.Image;
            const data = [
            ["projectOxford", _svgViewBox("0 0 100 100","<rect x='0.082'" + _widthHeightAttribs(100,100) + _msportalfxSvgColorClass + "15'/><path d='M39.259,23.767c11.003,0,20.39,6.915,24.055,16.634c1.728-0.556,3.568-0.858,5.479-0.858 c9.841,0,17.816,7.976,17.816,17.816c0,9.839-7.976,17.816-17.816,17.816c-5.235,0-23.332,0-29.533,0 c-14.195,0-25.704-11.509-25.704-25.705C13.555,35.274,25.063,23.767,39.259,23.767z'" + _msportalfxSvgColorClass + "01'/><g><g><path d='M49.078,67.522c-7.273,0-13.191-5.917-13.191-13.191c0-7.273,5.918-13.191,13.191-13.191 c7.274,0,13.191,5.918,13.191,13.191c0,0.68-0.051,1.358-0.153,2.024c-0.09,0.577-0.63,0.974-1.208,0.885 c-0.577-0.089-0.975-0.63-0.885-1.208c0.085-0.559,0.13-1.131,0.13-1.701c0-6.106-4.968-11.074-11.075-11.074 c-6.106,0-11.074,4.968-11.074,11.074c0,6.107,4.968,11.075,11.074,11.075c3.167,0,6.188-1.359,8.291-3.731 c0.387-0.436,1.056-0.477,1.494-0.089c0.438,0.388,0.477,1.058,0.088,1.494C56.447,65.903,52.849,67.522,49.078,67.522z'" + _msportalfxSvgColorClass + "15'/></g><g><path d='M53.761,59.511c-0.084,0-0.169-0.011-0.252-0.031c-0.305-0.074-0.559-0.279-0.698-0.559l-2.819-5.713 l-1.694,3.447c-0.178,0.362-0.547,0.592-0.95,0.592H42.16c-0.584,0-1.059-0.474-1.059-1.059s0.474-1.059,1.059-1.059h4.528 l2.352-4.785c0.177-0.361,0.545-0.591,0.948-0.591c0,0,0.001,0,0.001,0c0.403,0,0.771,0.229,0.95,0.589l3.216,6.515l2.098-1.524 c0.18-0.132,0.398-0.203,0.622-0.203h4.151c0.583,0,1.058,0.474,1.058,1.059s-0.475,1.059-1.058,1.059h-3.808l-2.834,2.062 C54.201,59.44,53.982,59.511,53.761,59.511z'" + _msportalfxSvgColorClass + "15'/></g><g><path d='M63.383,68.28c-0.258,0-0.517-0.094-0.72-0.283l-5.09-4.721c-0.428-0.397-0.453-1.068-0.055-1.496 c0.398-0.429,1.067-0.453,1.495-0.056l5.089,4.721c0.429,0.397,0.454,1.068,0.056,1.496C63.949,68.167,63.667,68.28,63.383,68.28z'" + _msportalfxSvgColorClass + "15'/></g></g>")],
            ["regenerateKeyOne", _svgViewBox("0 0 24 24","<path d='M20.6,10.3h-5.2V8.9h1.7V3.8l-1.7,0.4V2.7L18.9,2v6.9h1.7V10.3z'/><path d='M18.6,13c-0.2,3.5-3,6.2-6.5,6.1C8.5,19,5.5,16,5.5,12.4c0-2.1,1-4,2.6-5.2l3.3,3.1v-8H3l3,3C4,7,2.7,9.6,2.7,12.4 c0,5.2,4.2,9.5,9.4,9.6c5.1,0.1,9.1-3.9,9.2-9H18.6z'/>")],
            ["regenerateKeyTwo", _svgViewBox("0 0 24 24","<path d='M18.6,13c-0.2,3.5-3,6.2-6.5,6.1c-3.6-0.1-6.6-3.1-6.6-6.7c0-2.1,1-4,2.6-5.2l3.3,3.1v-8H3L6,5.3C4,7,2.7,9.6,2.7,12.4 c0,5.2,4.2,9.5,9.4,9.6c5.1,0.1,9.1-3.9,9.2-9H18.6z'/><path d='M20.9,10.3h-5.4V8.9l2.4-2.2c0.5-0.5,0.8-0.9,1-1.2c0.2-0.3,0.3-0.6,0.3-0.9c0-0.8-0.4-1.1-1.2-1.1c-0.7,0-1.4,0.3-2,0.8 V2.7C16.6,2.2,17.4,2,18.3,2c0.9,0,1.5,0.2,2,0.7c0.4,0.4,0.7,1,0.7,1.7c0,1-0.6,1.9-1.7,3l-1.7,1.5v0h3.3V10.3z'/>")],
            ["sampleA", _svgViewBox("0 0 78.678 54.401","<g>" + _polygonPoint + "13.646,50.317 39.338,23.253 46.909,37.625 55.651,29.173 67.773,50.035'" + _msportalfxSvgColorClass + "16'/><g><path d='M66.833,0.637H11.844c-6.228,0-11.277,5.05-11.277,11.276v30.447c0,6.228,5.05,11.276,11.277,11.276 h54.989c6.228,0,11.277-5.049,11.277-11.276V11.914C78.11,5.687,73.061,0.637,66.833,0.637z M73.077,38.219 c0,5.6-4.54,10.14-10.141,10.14H15.74c-5.601,0-10.141-4.54-10.141-10.14V16.058c0-5.6,4.54-10.142,10.141-10.142h47.196 c5.601,0,10.141,4.542,10.141,10.142V38.219z'" + _msportalfxSvgColorClass + "19'/></g>" + _circleCxCyR(19.562, 19.755, 7) + _msportalfxSvgColorClass + "14'/>" + _polygonPoint + "67.19,30.967 57.043,20.749 46.895,30.967 46.895,0.637 67.19,0.637'" + _msportalfxSvgColorClass + "10'/></g>")],
            ["sampleB", _svgViewBox("0 0 78.678 54.401","<g>" + _polygonPoint + "13.646,50.317 39.338,23.253 46.909,37.625 55.651,29.173 67.773,50.035'" + _msportalfxSvgColorClass + "16'/><g><path d='M66.833,0.637H11.844c-6.228,0-11.277,5.05-11.277,11.276v30.447c0,6.228,5.05,11.276,11.277,11.276 h54.989c6.228,0,11.277-5.049,11.277-11.276V11.914C78.11,5.687,73.061,0.637,66.833,0.637z M73.077,38.219 c0,5.6-4.54,10.14-10.141,10.14H15.74c-5.601,0-10.141-4.54-10.141-10.14V16.058c0-5.6,4.54-10.142,10.141-10.142h47.196 c5.601,0,10.141,4.542,10.141,10.142V38.219z'" + _msportalfxSvgColorClass + "19'/></g>" + _circleCxCyR(19.562, 19.755, 7) + _msportalfxSvgColorClass + "14'/>" + _polygonPoint + "67.19,30.967 57.043,20.749 46.895,30.967 46.895,0.637 67.19,0.637'" + _msportalfxSvgColorClass + "10'/></g>")],
            ["sampleC", _svgViewBox("0 0 78.678 54.401","<g>" + _polygonPoint + "13.646,50.317 39.338,23.253 46.909,37.625 55.651,29.173 67.773,50.035'" + _msportalfxSvgColorClass + "16'/><g><path d='M66.833,0.637H11.844c-6.228,0-11.277,5.05-11.277,11.276v30.447c0,6.228,5.05,11.276,11.277,11.276 h54.989c6.228,0,11.277-5.049,11.277-11.276V11.914C78.11,5.687,73.061,0.637,66.833,0.637z M73.077,38.219 c0,5.6-4.54,10.14-10.141,10.14H15.74c-5.601,0-10.141-4.54-10.141-10.14V16.058c0-5.6,4.54-10.142,10.141-10.142h47.196 c5.601,0,10.141,4.542,10.141,10.142V38.219z'" + _msportalfxSvgColorClass + "19'/></g>" + _circleCxCyR(19.562, 19.755, 7) + _msportalfxSvgColorClass + "14'/>" + _polygonPoint + "67.19,30.967 57.043,20.749 46.895,30.967 46.895,0.637 67.19,0.637'" + _msportalfxSvgColorClass + "10'/></g>")],
            ["sampleD", _svgViewBox("0 0 78.678 54.401","<g>" + _polygonPoint + "13.646,50.317 39.338,23.253 46.909,37.625 55.651,29.173 67.773,50.035'" + _msportalfxSvgColorClass + "16'/><g><path d='M66.833,0.637H11.844c-6.228,0-11.277,5.05-11.277,11.276v30.447c0,6.228,5.05,11.276,11.277,11.276 h54.989c6.228,0,11.277-5.049,11.277-11.276V11.914C78.11,5.687,73.061,0.637,66.833,0.637z M73.077,38.219 c0,5.6-4.54,10.14-10.141,10.14H15.74c-5.601,0-10.141-4.54-10.141-10.14V16.058c0-5.6,4.54-10.142,10.141-10.142h47.196 c5.601,0,10.141,4.542,10.141,10.142V38.219z'" + _msportalfxSvgColorClass + "19'/></g>" + _circleCxCyR(19.562, 19.755, 7) + _msportalfxSvgColorClass + "14'/>" + _polygonPoint + "67.19,30.967 57.043,20.749 46.895,30.967 46.895,0.637 67.19,0.637'" + _msportalfxSvgColorClass + "10'/></g>")],
            ["sampleE", _svgViewBox("0 0 78.678 54.401","<g>" + _polygonPoint + "13.646,50.317 39.338,23.253 46.909,37.625 55.651,29.173 67.773,50.035'" + _msportalfxSvgColorClass + "16'/><g><path d='M66.833,0.637H11.844c-6.228,0-11.277,5.05-11.277,11.276v30.447c0,6.228,5.05,11.276,11.277,11.276 h54.989c6.228,0,11.277-5.049,11.277-11.276V11.914C78.11,5.687,73.061,0.637,66.833,0.637z M73.077,38.219 c0,5.6-4.54,10.14-10.141,10.14H15.74c-5.601,0-10.141-4.54-10.141-10.14V16.058c0-5.6,4.54-10.142,10.141-10.142h47.196 c5.601,0,10.141,4.542,10.141,10.142V38.219z'" + _msportalfxSvgColorClass + "19'/></g>" + _circleCxCyR(19.562, 19.755, 7) + _msportalfxSvgColorClass + "14'/>" + _polygonPoint + "67.19,30.967 57.043,20.749 46.895,30.967 46.895,0.637 67.19,0.637'" + _msportalfxSvgColorClass + "10'/></g>")]
            ];
            declare var SVG: StringMap<MsPortalFx.Base.Image>;
            _setData(SVG, data);
        }
    }
}
