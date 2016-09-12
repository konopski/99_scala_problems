#!/bin/bash

set -e 
set -x

mkdir -p ~/.vim/{ftdetect,indent,syntax}

for d in ftdetect indent syntax 
do
  curl -o ~/.vim/$d/scala.vim https://raw.githubusercontent.com/derekwyatt/vim-scala/master/syntax/scala.vim
done
