myCanvasphysics
===============

A java based particle physics simulator.  Please feel free to help us develop this project.


The image is displayed using the "Canvas" class within java.awt.* This is included within the class \
"myCanvas."

Various types of forces and other user options are controlled by the user interface creating using Frame from 
Java.awt.*

The class "Vector" is how most of the motion is created within the particles.  Each "Particle" has a number of 
different variables which can change how it will interact with other particles.  Particles handle their own collisions
with walls, but collisions with other particles are included in a number of static methods within the "Collision"
class.  We are creating gravity in the class "gravityField."

The class "Universe" is responsible for storing all particles within an ArrayList and includes a number of methods
which have a widescale effect on all particles.

Every class we have written will have javadocs added for maximum clarity.  We plan to eventually have every method 
have a javadocs description.  We would prefer that any additional methods that are added be thoroughly explained.

The eventual plan is for this simulator to have the option to use any and all of the types of forces that a particle 
might experience within classical mechanics.  A good analogy would be to say that everything described in the first 
year of a university physics major excepting quantum mechanics and relativity has a place here.

Happy coding.
