====================
Specification 2: AI
====================

Currently, our team’s version of Quoridor supports two human players, but
does not support an artificial opponent. This problem will be solved via the
implementation of a “dumb” AI.

Problem Description
===================

Our version of Quoridor currently includes the basic logic necessary to play
the game. The code behind this logic supports human players only. This leaves a
single human player without an opponent to compete with. Quoridor is impossible
to play without a minimum of two players. The creation of an AI will guarantee
that a single human player will always have an opponent.

Requirements
------------

All functional requirements from our previous implementation will be used in
addition to the following:

* The program shall prompt the user for opponent type, AI or human
* The program shall create an instance of the opponent specified by the user
* The program shall keep track of the number of walls owned by AI
* The program shall choose between wall placement or player movement for the AI
* The program shall determine if the AI wall placement or AI movement is valid
* The program shall then autonomously place a wall or move the pawn
* The program shall check for a win condition

Nonfunctional requirement(s):

None

Use Cases
---------

Beginning the game with AI opponent:

1. Player will be presented with an opening ASCII window
    1.a. Four options will be presented on the ASCII window
      - Start player v. player
      - Start player v. AI
      - Help
      - Exit
    1.b. Player selects player v. AI from starting prompt
      - Game board is shown on the screen
      - Instance of AI is created
      - Game begins
      - Game ends when win condition is true
      - Window closes

Proposed Change
===============

The primary change our team is proposing in this sprint is the addition of a
“dumb” autonomous AI. The bulk of the AI’s functionality will be
implemented via the recycling of code used for implementing a human player.
This code will include logical decisions to include true-false conditions and
random number generation. The true-false conditions will be used primarily to
choose between a wall placement action or pawn movement action for the AI. The
AI checks if a move is valid and selects a different action if the move is
invalid. For example, the computer player always tries to move its pawn unless
there is no valid move in which case it will place a wall instead. Random
number generation will be used primarily for the location of a wall placement
or pawn movement. It will be restricted to the dimensions of the game board.
Classes and methods that the team intends to use to achieve these ends are as
follows:

1. AI - In charge of AI instantiation
    - getAIMove() - method of AIMovement randomly decides between a wall
      placement or pawn movement or the AI
    - AIPlaceWall() - method of AIMovement places an AI wall randomly in a
      valid location
    - AIPawnMove() - method of AIMovement which moves the AI’s pawn randomly
      in a valid direction
    - isValidMove() - method of AIMovement which checks if the AI’s wall
      placement or pawn move is valid/within the dimensions of the game board

Alternatives
------------

The alternative to a "dumb" AI could include the creation of a "smart" AI.
A "smart" AI would make decisions more similar to that of a human player.
This could be achieved by way of a more complex decision making algorithm
which bases its decisions on the state of the game board.

Testing
=======

Testing will be done with automated JUnit tests.

Documentation
=============

The code will be populated with minimal in-line comments throughout. The
comments have the sole purpose of aiding our team's understanding of key
blocks.

Implementation
==============

Work Items
----------

1. Creating the AI opponent - Andrew Lee, Hampton Ford, William Nikolai
2. Creating wall placement and pawn movement logic for the AI opponent -
   Andrew Lee, Hampton Ford, William Nikolai
3. Creating random number generator specific to wall placement - Andrew Lee,
   Hampton Ford, William Nikolai
4. Creating random number generator specific to pawn placement - Andrew Lee,
   Hampton Ford, William Nikolai

Assignee(s)
-----------

1. Andrew Lee - primary program architect, in charge of AI instantiation
2. Hampton Ford - secondary program architect, in charge of AI decision logic
3. William Nikolai - tertiary program architect, in charge of AI random number
   generation
4. Lindsay Brummett - primary specification author
5. Zachary Olszewski - secondary specification author, in charge of
   formatting

References
==========

None
