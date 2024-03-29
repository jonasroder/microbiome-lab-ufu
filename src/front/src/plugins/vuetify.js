import {createVuetify} from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import {aliases, fa} from 'vuetify/iconsets/fa'
import '../styles/main.scss';

export default createVuetify({
	theme: {
		defaultTheme: 'light',
		themes      : {
			light: {
				colors: {
					primary   : '#6fbfd9',
					secondary : '#b0bec5',
					accent    : '#8c9eff',
					background: '#d7e3e5',

					barrasSperior: '#00bdda',
					barraLateral : '#f6f8f8',
					formArea     : '#ffffff',
					azulEscuro   : '#34568B',
					cinzaAzulado : '#9EADBA',

					textColor: '#9EADBA',
					iconColor: '#9EADBA',
				}
			},
			dark : {
				dark  : true,
				colors: {
					primary   : '#388E3C',
					secondary : '#66BB6A',
					accent    : '#81C784',
					background: '#2E7D32',
				}
			},
		},
	},

	icons: {
		defaultSet: 'fa',
		aliases,
		sets      : {
			fa,
		},
	},

	defaults: {
		global       : {
			ripple   : true,
			textColor: 'textColor',
			iconColor: 'iconColor',
		},
		VAutocomplete: {
			multiple     : false,
			clearable    : true,
			chips        : false,
			closableChips: true,
			itemTitle    : 'label',
			itemValue    : 'value',
			variant      : 'outlined',
			color        : 'primary',
			density      : 'compact'
		},
		VTextField   : {
			variant: 'outlined',
			color  : 'primary',
			density: 'compact'
		},
		VTextarea    : {
			variant: 'outlined',
			color  : 'primary',
			density: 'compact'
		},
		VRadio       : {
			color: 'primary',

		},
		VRadioGroup  : {
			color: 'primary',
			inline: true
		},
		VSwitch      : {
			color: 'azulEscuro',
			inset: true
		},
		VFileInput   : {
			variant: 'outlined',
			color  : 'primary',
			density: 'compact'
		},
		VTooltip     : {
			activator: 'parent',
			location : 'top'
		},
		VBtn         : {
			ripple: 'true',
		},

	},

	components,
	directives,
})
