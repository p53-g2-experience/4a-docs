# Generated by Django 3.2.7 on 2021-11-20 23:46

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('authApp', '0007_user_activo'),
    ]

    operations = [
        migrations.AlterField(
            model_name='user',
            name='activo',
            field=models.CharField(default='S', max_length=1, verbose_name='Activo'),
        ),
    ]
