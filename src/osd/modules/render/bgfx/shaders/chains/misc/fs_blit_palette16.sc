$input v_color0, v_texcoord0

// license:BSD-3-Clause
// copyright-holders:Ryan Holtz

#include "common.sh"

// Samplers
SAMPLER2D(s_tex, 0);
SAMPLER2D(s_pal, 1);

uniform vec4 u_tex_size0;
uniform vec4 u_inv_tex_size0;
uniform vec4 u_inv_tex_size1;

void main()
{
	vec4 srcpix = texture2D(s_tex, v_texcoord0.xy);
	vec2 palette_uv = (srcpix.bg * vec2(256.0, 256.0)) * u_inv_tex_size1.xy;
	gl_FragColor = vec4(texture2D(s_pal, palette_uv).rgb, 1.0) * v_color0;
}
