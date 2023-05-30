/*
 Highcharts JS v11.0.1 (2023-05-08)

 (c) 2009-2021 Highsoft AS

 License: www.highcharts.com/license
*/
'use strict';(function(a){"object"===typeof module&&module.exports?(a["default"]=a,module.exports=a):"function"===typeof define&&define.amd?define("highcharts/themes/high-contrast-dark",["highcharts"],function(b){a(b);a.Highcharts=b;return a}):a("undefined"!==typeof Highcharts?Highcharts:void 0)})(function(a){function b(a,c,b,d){a.hasOwnProperty(c)||(a[c]=d.apply(null,b),"function"===typeof CustomEvent&&window.dispatchEvent(new CustomEvent("HighchartsModuleLoaded",{detail:{path:c,module:a[c]}})))}
a=a?a._modules:{};b(a,"Extensions/Themes/HighContrastDark.js",[a["Core/Defaults.js"]],function(a){var c=a.setOptions,b;(function(a){a.options={colors:"#67B9EE #CEEDA5 #9F6AE1 #FEA26E #6BA48F #EA3535 #8D96B7 #ECCA15 #20AA09 #E0C3E4".split(" "),chart:{backgroundColor:"#1f1f20",plotBorderColor:"#606063"},title:{style:{color:"#F0F0F3"}},subtitle:{style:{color:"#F0F0F3"}},xAxis:{gridLineColor:"#707073",labels:{style:{color:"#F0F0F3"}},lineColor:"#707073",minorGridLineColor:"#505053",tickColor:"#707073",
title:{style:{color:"#F0F0F3"}}},yAxis:{gridLineColor:"#707073",labels:{style:{color:"#F0F0F3"}},lineColor:"#707073",minorGridLineColor:"#505053",tickColor:"#707073",title:{style:{color:"#F0F0F3"}}},tooltip:{backgroundColor:"rgba(0, 0, 0, 0.85)",style:{color:"#F0F0F3"}},plotOptions:{series:{dataLabels:{color:"#F0F0F3"},marker:{lineColor:"#333"}},boxplot:{fillColor:"#505053"},candlestick:{lineColor:"white"},errorbar:{color:"white"},map:{nullColor:"#353535"}},legend:{backgroundColor:"transparent",itemStyle:{color:"#F0F0F3"},
itemHoverStyle:{color:"#FFF"},itemHiddenStyle:{color:"#606063"},title:{style:{color:"#D0D0D0"}}},credits:{style:{color:"#F0F0F3"}},drilldown:{activeAxisLabelStyle:{color:"#F0F0F3"},activeDataLabelStyle:{color:"#F0F0F3"}},navigation:{buttonOptions:{symbolStroke:"#DDDDDD",theme:{fill:"#505053"}}},rangeSelector:{buttonTheme:{fill:"#505053",stroke:"#000000",style:{color:"#eee"},states:{hover:{fill:"#707073",stroke:"#000000",style:{color:"#F0F0F3"}},select:{fill:"#303030",stroke:"#101010",style:{color:"#F0F0F3"}}}},
inputBoxBorderColor:"#505053",inputStyle:{backgroundColor:"#333",color:"#F0F0F3"},labelStyle:{color:"#F0F0F3"}},navigator:{handles:{backgroundColor:"#666",borderColor:"#AAA"},outlineColor:"#CCC",maskFill:"rgba(180,180,255,0.2)",series:{color:"#7798BF",lineColor:"#A6C7ED"},xAxis:{gridLineColor:"#505053"}},scrollbar:{barBackgroundColor:"#808083",barBorderColor:"#808083",buttonArrowColor:"#CCC",buttonBackgroundColor:"#606063",buttonBorderColor:"#606063",rifleColor:"#FFF",trackBackgroundColor:"#404043",
trackBorderColor:"#404043"}};a.apply=function(){c(a.options)}})(b||(b={}));return b});b(a,"masters/themes/high-contrast-dark.src.js",[a["Core/Globals.js"],a["Extensions/Themes/HighContrastDark.js"]],function(a,b){a.theme=b.options;b.apply()})});
//# sourceMappingURL=high-contrast-dark.js.map