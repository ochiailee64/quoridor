======================
Specification Template
======================

The introductory paragraph should succinctly describe the problem and the
proposed solution. Extensive technical details should not be provided in this
paragraph; the description should be understandable by others, even if they
are not familiar with the larger system.

General guidance for this specification:

* Replace the existing text with the appropriate details for the feature to be
  implemented. Don't forget to replace the title of the specification with the
  name of the feature. Do not delete any sections of this template.

* This document is formatted via reStructuredText [RST]_. Anyone who is not
  familiar with reStructuredText markup may benefit from its quick reference
  guide [QuickRST]_.

* Please wrap lines at 79 characters.

Problem Description
===================

What is the problem? This section provides a detailed description of the
problem.

Requirements
------------

What are the functional and non-function requirements that express the desired
behavior of the system?

Use Cases
---------

A *use case*, at a high level, is a story about an observable interaction (a
"thread of usage") between the system and the environment. Each story is
described from the point of view of an actor that interacts with the system
in some way.

Each feature must include at least one use case that answers the following
questions:

* Who is the primary actor and the secondary actor(s)?
* What are the actors' goals?
* What preconditions exist before the story begins and postconditions after the
  story ends?
* What main tasks or functions are performed by the actor(s)?
* What variations in the actors' interactions are possible (e.g., exceptions)?

Proposed Change
===============

This section describes your design -- i.e., how the prior requirements will be
satisfied by the system. What classes, data structures, and algorithms will you
use? What ancillary changes must be made to the system's existing design in the
process of implementing your change? Considerable detail should be provided --
enough that someone else could implement this feature with nothing beyond this
specification for guidance.

If this feature is part of a larger effort, include at least one paragraph
describing how this feature fits into the larger system. Be sure to include
the scope of this feature so it is clear where this effort ends. Very large
features may be broken up into multiple pieces and implemented separately,
in which case it is necessary to clearly delineate where each piece ends.

Alternatives
------------

What other options exist to satisfy the requirements? Why is the proposed
approach better than those options?

Testing
=======

What is the test plan? That is, how will this change be tested? Are there
specific test cases to guard against expected faults?

Provide a detailed rationale if some portions of the proposed change are not
testable or no specific test cases will accompany the implementation.

Documentation
=============

What documentation should accompany this change -- e.g., in-line comments in
the source code or user manuals? Be sure to identify the target audience for
various forms of documentation if it isn't obvious from the context (e.g.,
source code comments are typically intended for developers).

Implementation
==============

Work Items
----------

If this feature will be implemented in phases (and most features should be!),
enumerate the individual pieces that will collectively implement the proposed
change. Work items may be supported by different people, but they also provide
a rough timeline for the proposed feature.

Assignee(s)
-----------

Who is responsible for implementing this specification? If the prior work items
require multiple contributors, please designate the "lead" who will oversee all
aspects of the work and other contributors, including those contributors'
specific contributions.

Primary assignee:
  Name and Email

Other contributors:
  Name and Email

References
==========

Please include any relevant references that are related to the problem or the
proposed change. The references should supplement the material already in this
specification -- i.e., the specification must make sense even if the references
are not available.

.. [RST] David Goodger, "reStructuredText Markup Specification," May 2016.
   Online: http://docutils.sourceforge.net/docs/ref/rst/restructuredtext.html

.. [QuickRST] Quick reStructuredText. Online:
   http://docutils.sourceforge.net/docs/user/rst/quickref.html
