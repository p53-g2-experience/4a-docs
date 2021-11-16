from rest_framework import serializers
from authApp.models.user import User

class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ['id', 'username', 'password', 'name', 'email', 'telefono', 'activo']


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
        
        }