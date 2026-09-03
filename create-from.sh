#!/usr/bin/env sh

set -e

fromc=$1
toc=$2

from="./challenges/$fromc"
to="./challenges/$toc"

[ -d "$from" ] || (echo "challenge $from doesn't exist" && exit 1)

mkdir $to
cp -r $from/* $to

pushd $to
rm -rf .idea/ target/
find ./ -type f -exec sed -i "" -e "s/$fromc/$toc/g" {} \;
popd
