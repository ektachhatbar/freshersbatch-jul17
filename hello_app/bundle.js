/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	var _generators = __webpack_require__(1);

	//testConstants();
	//testScoping();
	//testEnhancedObjectProperties();
	//testArrow();
	//testDefaultValues();
	//testRestParameters();
	//testSpreadOperator();
	//testTemplateLiterals();
	//testArrayMatching();
	//testDeepMatching();
	//testClassesModules();
	//testSymbols();
	//testIterator();
	(0, _generators.testGenerators)(); //console.log("Hello ES6");
	//document.write("<h1>Hello ES6</h1>");


	//import {testConstants} from './components/constants.js';
	//import {testScoping} from './components/scoping.js';
	//import {testEnhancedObjectProperties} from './components/enhanced_object_properties.js';
	//import {testArrow} from './components/arrow.js';
	//import {testDefaultValues} from './components/default_values.js';
	//import {testRestParameters} from './components/rest_parameters.js';
	//import {testSpreadOperator} from './components/spread_operator.js';
	//import {testTemplateLiterals} from './components/template_literals.js';
	//import {testArrayMatching} from './components/array_matching.js';
	//import {testDeepMatching} from './components/deep_matching.js';
	//import {testClassesModules} from './components/classes_modules.js';
	//import {testSymbols} from './components/symbols.js';
	//import {testIterator} from './components/iterator.js';

/***/ },
/* 1 */
/***/ function(module, exports) {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.testGenerators = testGenerators;

	var _marked = [amstrong].map(regeneratorRuntime.mark);

	function amstrong() {
	    var b, z, c, a, reset;
	    return regeneratorRuntime.wrap(function amstrong$(_context) {
	        while (1) {
	            switch (_context.prev = _context.next) {
	                case 0:
	                    c = 0;
	                    a = 153;

	                    z = a;
	                    while (z > 0) {
	                        b = z % 10;
	                        c = c + b * b * b;
	                        z = parseInt(z / 10);
	                    }
	                    _context.next = 6;
	                    return a;

	                case 6:
	                    reset = _context.sent;

	                    if (reset) {
	                        a = 155;
	                    }

	                case 8:
	                case "end":
	                    return _context.stop();
	            }
	        }
	    }, _marked[0], this);
	}

	function testGenerators() {
	    var gen = amstrong();
	    console.log(gen.next());
	}

/***/ }
/******/ ]);