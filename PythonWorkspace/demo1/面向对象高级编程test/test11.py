class Screen(object):
    @property
    def width(self):
        return self._width
    @width.setter
    def width(self,value):
        self._width=value

    @property
    def height(self):
        return self._height
    @height.setter
    def height(self,value):
        self._height=value

    @property
    def resolution(self):
         return self._height*self._width


s=Screen();
s.height=3;
s.width=5;
print(s.resolution)
