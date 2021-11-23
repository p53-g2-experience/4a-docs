from typing import cast
from django.db import models
from django.db.models.deletion import  PROTECT
from django.db.models.fields import AutoField, CharField, TextField
from django.db.models.fields.related import ForeignKey

class Word(models.Model):
    id = AutoField(primary_key=True)
    morfo = TextField("morfo",max_length=100)
    morfema = TextField("morfema",max_length=100)
    translation = TextField("translation",max_length=100)
    lexical_translation = TextField("lexical_translation", max_length=300)
    observations = TextField("observations",max_length=300)
    creation_date = models.DateTimeField(null=True)
    last_modification = models.DateTimeField(null=True)


