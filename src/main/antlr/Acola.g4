grammar Acola;
//TODO When should which whitespaces appear?
brain: 'brain' whitespace+ '"' IDENTIFIER '"' whitespace* '{' whitespace* (instruction whitespace_withline)+ '}' whitespace* EOF;

instruction : mark
            | unmark
            | set
            | unset
            | test
            | turn
            | move
            | sense
            | pickup
            | drop
            | flip
            | jump
            | direction
            | breed;

mark : 'mark' whitespace_withoutline+ NUMBER;
unmark: 'unmark' whitespace_withoutline+ NUMBER;
set: 'set' whitespace_withoutline+ NUMBER;
unset: 'unset' whitespace_withoutline+ NUMBER;
test: 'test' whitespace_withoutline+ NUMBER elsePart;
turn: 'turn' whitespace_withoutline+ RELATIVEDIRECTION;
move: 'move' elsePart;
sense: 'sense' whitespace_withoutline+ RELATIVEDIRECTION whitespace_withoutline+ (SENSEABLE | markerSense) elsePart;
markerSense: 'marker' whitespace_withoutline+ NUMBER;
pickup: 'pickup' elsePart;
drop: 'drop' elsePart;
flip: 'flip' whitespace_withoutline+ NUMBER elsePart;
jump: 'jump' whitespace_withoutline+ NUMBER;
direction: 'direction' whitespace_withoutline+ DIRECTION elsePart;
breed: 'breed' elsePart;
elsePart : whitespace_withoutline+ 'else' whitespace_withoutline+ NUMBER;

whitespace: (' ' | '\t' | '\n' | linecomment | blockcomment_dontcare);
whitespace_withoutline: (' ' | '\t' | blockcomment_withoutline);
whitespace_withline: whitespace_withoutline*('\n' | linecomment | blockcomment_withline)whitespace*;
linecomment: '/' '/' ~('\n')*?'\n';
blockcomment_dontcare: '/' '*' textwithoutcommentend '*' '/';
blockcomment_withoutline: '/' '*' textwithoutnewlineandcommentend '*' '/';
blockcomment_withline: '/' '*' textwithoutnewlineandcommentend '\n' textwithoutcommentend '*' '/';

textwithoutnewlineandcommentend: starandslasnotcommentendend (nostarandslashandnewline starandslasnotcommentendend)*;
textwithoutcommentend: starandslasnotcommentendend (nostarandslash starandslasnotcommentendend)*;
nostarandslash: ~('*' | '/')+;
nostarandslashandnewline: ~('*' | '/'| '\n')+;
starandslasnotcommentendend: '/'* '*'*;

SENSEABLE : 'foe' | 'food' | 'rock' | 'home' | 'friend' | 'foehome' | 'foemarker' | 'friendfood' | 'foefood' | 'antlion';
DIRECTION : 'northwest' | 'northeast' | 'east' | 'southeast' | 'southwest' | 'west';
RELATIVEDIRECTION: 'here' | 'ahead' | 'left' | 'right';
IDENTIFIER : [a-zA-Z_.-][a-zA-Z0-9_.-]+;
NUMBER : [0-9]+;
ERROR: .;
