% 1 - guess
{session(S, D, OR, H) : planningDay(D)} == 1 :- sessionID(S), operatingRoom(OR,_), hours(H).
{mss(OR, S, SP, D) : specialty(SP), operatingRoom(OR, SP)} == 1 :-  session(S, D, OR,_).

% 2 - define
effectiveShare(SP, PERCENTAGE) :- SHIFTS = #count{ OR,S,D : mss(OR,S,SP,D)}, specialty(SP), PERCENTAGE = ((SHIFTS*100) / (s_count*or_count)).

% 3 - check
:- session(S,D,_,_), S < ((2*D)-1).
:- session(S,D,_,_), S > (2*D).
:- effectiveShare(SP, PERCENTAGE), targetShare(SP,TARGET,ERROR), PERCENTAGE < (TARGET-ERROR).
:- effectiveShare(SP, PERCENTAGE), targetShare(SP,TARGET,ERROR), PERCENTAGE > (TARGET+ERROR).
:- effectiveShare(SP, PERCENTAGE), PERCENTAGE = 0.

% 4 - optimize
 :~   effectiveShare(SP, ES), targetShare(SP,TS,ERR), W = |ES-TS|. [ W@1 ]

% 5 - display
#show effectiveShare/2.
#show targetShare/3.
