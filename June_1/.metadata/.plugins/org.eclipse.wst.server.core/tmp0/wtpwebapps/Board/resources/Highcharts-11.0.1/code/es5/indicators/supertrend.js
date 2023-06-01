/*
 Highstock JS v11.0.1 (2023-05-08)

 Indicator series type for Highcharts Stock

 (c) 2010-2021 Wojciech Chmiel

 License: www.highcharts.com/license
*/
'use strict';(function(a){"object"===typeof module&&module.exports?(a["default"]=a,module.exports=a):"function"===typeof define&&define.amd?define("highcharts/indicators/supertrend",["highcharts","highcharts/modules/stock"],function(m){a(m);a.Highcharts=m;return a}):a("undefined"!==typeof Highcharts?Highcharts:void 0)})(function(a){function m(a,g,m,v){a.hasOwnProperty(g)||(a[g]=v.apply(null,m),"function"===typeof CustomEvent&&window.dispatchEvent(new CustomEvent("HighchartsModuleLoaded",{detail:{path:g,
module:a[g]}})))}a=a?a._modules:{};m(a,"Stock/Indicators/Supertrend/SupertrendIndicator.js",[a["Core/Series/SeriesRegistry.js"],a["Core/Utilities.js"],a["Core/Chart/StockChart.js"]],function(a,g,m){function v(a,e,b){return{index:e,close:a.yData[e][b],x:a.xData[e]}}var C=this&&this.__extends||function(){var a=function(e,b){a=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(b,a){b.__proto__=a}||function(b,a){for(var r in a)Object.prototype.hasOwnProperty.call(a,r)&&(b[r]=a[r])};return a(e,
b)};return function(e,b){function r(){this.constructor=e}if("function"!==typeof b&&null!==b)throw new TypeError("Class extends value "+String(b)+" is not a constructor or null");a(e,b);e.prototype=null===b?Object.create(b):(r.prototype=b.prototype,new r)}}(),z=a.seriesTypes,D=z.atr,A=z.sma,E=g.addEvent,B=g.correctFloat,F=g.isArray;z=g.extend;var y=g.merge,G=g.objectEach;g=function(a){function e(){var b=null!==a&&a.apply(this,arguments)||this;b.data=void 0;b.linkedParent=void 0;b.options=void 0;b.points=
void 0;return b}C(e,a);e.prototype.init=function(){var b=this;a.prototype.init.apply(b,arguments);var r=E(m,"afterLinkSeries",function(){if(b.options){var a=b.options;a.cropThreshold=b.linkedParent.options.cropThreshold-(a.params.period-1)}r()},{order:1})};e.prototype.drawGraph=function(){var b=this,a=b.options,q=b.linkedParent,e=q?q.points:[],g=b.points,m=b.graph,w=e.length-g.length;w=0<w?w:0;for(var H={options:{gapSize:a.gapSize}},l={top:[],bottom:[],intersect:[]},x={top:{styles:{lineWidth:a.lineWidth,
lineColor:a.fallingTrendColor||a.color,dashStyle:a.dashStyle}},bottom:{styles:{lineWidth:a.lineWidth,lineColor:a.risingTrendColor||a.color,dashStyle:a.dashStyle}},intersect:a.changeTrendLine},f,c,d,k,h,p,n,t,u=g.length;u--;)f=g[u],c=g[u-1],d=e[u-1+w],k=e[u-2+w],h=e[u+w],p=e[u+w+1],n=f.options.color,t={x:f.x,plotX:f.plotX,plotY:f.plotY,isNull:!1},!k&&d&&q.yData[d.index-1]&&(k=v(q,d.index-1,3)),!p&&h&&q.yData[h.index+1]&&(p=v(q,h.index+1,3)),!d&&k&&q.yData[k.index+1]?d=v(q,k.index+1,3):!d&&h&&q.yData[h.index-
1]&&(d=v(q,h.index-1,3)),f&&d&&h&&k&&f.x!==d.x&&(f.x===h.x?(k=d,d=h):f.x===k.x?(d=k,k={close:q.yData[d.index-1][3],x:q.xData[d.index-1]}):p&&f.x===p.x&&(d=p,k=h)),c&&k&&d?(h={x:c.x,plotX:c.plotX,plotY:c.plotY,isNull:!1},f.y>=d.close&&c.y>=k.close?(f.color=n||a.fallingTrendColor||a.color,l.top.push(t)):f.y<d.close&&c.y<k.close?(f.color=n||a.risingTrendColor||a.color,l.bottom.push(t)):(l.intersect.push(t),l.intersect.push(h),l.intersect.push(y(h,{isNull:!0})),f.y>=d.close&&c.y<k.close?(f.color=n||a.fallingTrendColor||
a.color,c.color=n||a.risingTrendColor||a.color,l.top.push(t),l.top.push(y(h,{isNull:!0}))):f.y<d.close&&c.y>=k.close&&(f.color=n||a.risingTrendColor||a.color,c.color=n||a.fallingTrendColor||a.color,l.bottom.push(t),l.bottom.push(y(h,{isNull:!0}))))):d&&(f.y>=d.close?(f.color=n||a.fallingTrendColor||a.color,l.top.push(t)):(f.color=n||a.risingTrendColor||a.color,l.bottom.push(t)));G(l,function(a,c){b.points=a;b.options=y(x[c].styles,H);b.graph=b["graph"+c+"Line"];A.prototype.drawGraph.call(b);b["graph"+
c+"Line"]=b.graph});b.points=g;b.options=a;b.graph=m};e.prototype.getValues=function(a,e){var b=e.period;e=e.multiplier;var g=a.xData,m=a.yData,r=[],w=[],v=[],l=0===b?0:b-1,x=[],f=[],c;if(!(g.length<=b||!F(m[0])||4!==m[0].length||0>b)){a=D.prototype.getValues.call(this,a,{period:b}).yData;for(c=0;c<a.length;c++){var d=m[l+c];var k=m[l+c-1]||[];var h=x[c-1];var p=f[c-1];var n=v[c-1];0===c&&(h=p=n=0);b=B((d[1]+d[2])/2+e*a[c]);var t=B((d[1]+d[2])/2-e*a[c]);x[c]=b<h||k[3]>h?b:h;f[c]=t>p||k[3]<p?t:p;if(n===
h&&d[3]<x[c]||n===p&&d[3]<f[c])var u=x[c];else if(n===h&&d[3]>x[c]||n===p&&d[3]>f[c])u=f[c];r.push([g[l+c],u]);w.push(g[l+c]);v.push(u)}return{values:r,xData:w,yData:v}}};e.defaultOptions=y(A.defaultOptions,{params:{index:void 0,multiplier:3,period:10},risingTrendColor:"#06b535",fallingTrendColor:"#f21313",changeTrendLine:{styles:{lineWidth:1,lineColor:"#333333",dashStyle:"LongDash"}}});return e}(A);z(g.prototype,{nameBase:"Supertrend",nameComponents:["multiplier","period"]});a.registerSeriesType("supertrend",
g);"";return g});m(a,"masters/indicators/supertrend.src.js",[],function(){})});
//# sourceMappingURL=supertrend.js.map