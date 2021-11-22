from rest_framework import serializers
from authApp.models.user import User

class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ['id', 'username', 'password', 'name', 'email', 'telefono', 'activo']

#Lo siguiente no está en la pagina 5 del archivo C4a.AP.01. Microservicio AuthMS

def create(self,validated_data):
        userIntance = User.objects.create(**validated_data)
        return userIntance

def to_representation(self, obj):
        user = User.objects.get(id=obj.id)
        return{
            'id': user.id,
            'username': user.username,
            'name': user.name,
            'email': user.email,
            'telefono': user.telefono,
            'activo': user.activo            
        }